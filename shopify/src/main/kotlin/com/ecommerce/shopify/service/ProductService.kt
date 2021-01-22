package com.ecommerce.shopify.service

import com.ecommerce.shopify.model.product.GetProductRequest
import com.ecommerce.shopify.model.product.Product
import com.ecommerce.shopify.remote.GraphQLClient
import com.ecommerce.shopify.remote.ProductClient
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productClient: ProductClient,
    private val graphQLService: GraphQLService,
    private val graphQLCliect: GraphQLClient
) {

    fun searchProductByTitle(title: String) {
        graphQLCliect.findProducts(graphQLService.buildProductSearchQueryByTitle(title))
    }

    fun importProduct(productId: Long): Product =
        productClient.getSingleProduct(productId).apply {
            images?.let { images ->
                variants?.forEach { it.image = images[it.imageId] }
            }
        }

    fun importAllProducts() {
        productClient.getProducts(GetProductRequest(limit = 250))?.map {
            it?.apply {
                images?.let { images ->
                    variants?.forEach { variant -> variant.image = images[variant.imageId] }
                }
            }
        }
    }
}