package com.ecommerce.shopify.config.interceptor

import com.ecommerce.shopify.repository.CredentialsRepository
import com.ecommerce.shopify.utils.AUTHORIZATION_HEADER
import com.ecommerce.shopify.utils.authorizationHeaderValue
import feign.RequestInterceptor
import feign.RequestTemplate

class ShopifyCredentialsInterceptor(private val credentialsRepository: CredentialsRepository) : RequestInterceptor {
    override fun apply(request: RequestTemplate?) {
        request?.apply {
            credentialsRepository.findTopByOrderByIdDesc().run {
                target(store.setUpUrl())
                header(AUTHORIZATION_HEADER, authorizationHeaderValue(apiKey, password))
            }
        }
    }

    companion object {
        private fun String.setUpUrl() = "https://$this.myshopify.com/"
    }
}