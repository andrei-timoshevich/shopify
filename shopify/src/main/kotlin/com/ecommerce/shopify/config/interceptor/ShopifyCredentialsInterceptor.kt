package com.ecommerce.shopify.config.interceptor

import com.ecommerce.shopify.repository.CredentialsRepository
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.util.Base64Utils

class ShopifyCredentialsInterceptor(private val credentialsRepository: CredentialsRepository) : RequestInterceptor {
    override fun apply(request: RequestTemplate?) {
        request?.apply {
            credentialsRepository.findTopByOrderByIdDesc().run {
                target(store.setUpUrl())
                header(AUTHORIZATION_HEADER, authorizationValue(apiKey, password))
            }
        }
    }

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
        private fun String.setUpUrl() = "https://$this.myshopify.com/";
        private fun authorizationValue(apiKey: String, password: String) =
            "Basic " + Base64Utils.encodeToString("$apiKey:$password".toByteArray())
    }
}