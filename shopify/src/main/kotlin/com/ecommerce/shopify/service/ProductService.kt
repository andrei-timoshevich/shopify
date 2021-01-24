package com.ecommerce.shopify.service

import com.ecommerce.shopify.model.product.GetProductRequest
import com.ecommerce.shopify.model.product.Product
import com.ecommerce.shopify.remote.GraphQLClient
import com.ecommerce.shopify.remote.ProductClient
import com.ecommerce.shopify.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
        private val productClient: ProductClient,
        private val graphQLService: GraphQLService,
        private val graphQLClient: GraphQLClient,
        private val productRepository: ProductRepository
) {

    fun searchProductByTitle(title: String) =
            graphQLClient.findProducts(graphQLService.buildProductSearchQueryByTitle(title))
                    ?.data?.products?.edges?.map { it?.node }


    fun importProduct(productId: Long) =
            productClient.getSingleProduct(productId)
                    ?.applyImagesToVariant()
                    ?.let { productRepository.save(it) }


    fun importAllProducts() {
        productClient.getProducts(GetProductRequest(limit = 250))?.map {
            it?.applyImagesToVariant()
        }
    }

    private fun Product.applyImagesToVariant() = apply {
        images?.let { images ->
            variants?.forEach { it.image = images[it.imageId] }
        }
    }
}