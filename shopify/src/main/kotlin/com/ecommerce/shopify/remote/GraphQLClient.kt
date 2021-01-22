package com.ecommerce.shopify.remote

import com.ecommerce.shopify.config.interceptor.ShopifyCredentialsInterceptor
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "graphql-client",
    url = "\${shopify.api.url}",
    configuration = [ShopifyCredentialsInterceptor::class]
)
interface GraphQLClient {

    @PostMapping("/admin/api/2021-01/graphql.json", consumes = ["application/graphql"])
    fun findProducts(@RequestBody query: String): String
}