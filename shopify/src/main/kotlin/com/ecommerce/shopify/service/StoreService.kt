package com.ecommerce.shopify.service

import com.ecommerce.shopify.model.Credentials
import com.ecommerce.shopify.remote.CredentialsClient
import org.springframework.stereotype.Service
import org.springframework.util.Base64Utils
import java.net.URI

@Service
class StoreService(private val credentialsClient: CredentialsClient) {

    fun validateCredentials(credentials: Credentials) {
        credentials.run {
            credentialsClient.validateCredentials(
                mapOf(AUTHORIZATION_HEADER to authorizationValue(apiKey, password)),
                this.createURI()
            )
        }
    }

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
        private fun Credentials.createURI() = URI("https://$store.myshopify.com")
        private fun authorizationValue(apiKey: String, password: String) =
            "Basic " + Base64Utils.encodeToString("$apiKey:$password".toByteArray())
    }
}