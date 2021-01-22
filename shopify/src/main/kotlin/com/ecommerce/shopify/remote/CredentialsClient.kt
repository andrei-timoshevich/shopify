package com.ecommerce.shopify.remote

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import java.net.URI

@FeignClient(name = "credentials-client", url = "\${shopify.api.url}")
interface CredentialsClient {

    @GetMapping("/admin/api/2021-01/shop.json")
    fun validateCredentials(@RequestHeader authorizationHeader: Map<String, String>, baseUrl: URI): String
}