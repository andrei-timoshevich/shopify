package com.ecommerce.shopify.remote

import com.ecommerce.shopify.config.FeignEmbedConfig
import com.ecommerce.shopify.config.interceptor.ShopifyCredentialsInterceptor
import com.ecommerce.shopify.model.product.GetProductRequest
import com.ecommerce.shopify.model.product.Product
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    "product-client",
    url = "\${shopify.api.url}",
    configuration = [ShopifyCredentialsInterceptor::class, FeignEmbedConfig::class]
)
interface ProductClient {

    @GetMapping("/admin/api/2021-01/products/count.json")
    fun getCountOfProducts(@RequestBody filter: String = COUNT_FILTER): Long

    @GetMapping("/admin/api/2021-01/products/{productId}.json")
    fun getSingleProduct(@PathVariable productId: Long): Product

    @GetMapping("/admin/api/2021-01/products.json")
    fun getProducts(@RequestBody request: GetProductRequest): List<Product?>?

    companion object {
        private const val COUNT_FILTER = """"{"published_status" : "published"}"""
    }
}