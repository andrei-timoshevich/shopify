package com.ecommerce.shopify.remote

import com.ecommerce.shopify.config.interceptor.ShopifyCredentialsInterceptor
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "store-client", url = "\${shopify.api.url}", configuration = [ShopifyCredentialsInterceptor::class])
interface StoreClient {

    @GetMapping("/admin/api/2021-01/shop.json")
    fun pingShop() = Unit
}