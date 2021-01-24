package com.ecommerce.shopify.service

import com.ecommerce.shopify.model.Credentials
import com.ecommerce.shopify.remote.CredentialsClient
import com.ecommerce.shopify.repository.CredentialsRepository
import com.ecommerce.shopify.utils.AUTHORIZATION_HEADER
import com.ecommerce.shopify.utils.authorizationHeaderValue
import com.ecommerce.shopify.utils.createURI
import feign.FeignException
import org.springframework.stereotype.Service

@Service
class StoreService(private val credentialsClient: CredentialsClient,
                   private val credentialsRepository: CredentialsRepository) {

    fun validateCredentials(credentials: Credentials) {
        try {
            pingStoreWithCredentials(credentials)
        } catch (ex: FeignException) {
            //todo
        }
    }

    fun saveCredentials(credentials: Credentials) {
        validateCredentials(credentials)
        credentialsRepository.save(credentials)
    }

    private fun pingStoreWithCredentials(credentials: Credentials) =
            credentials.run {
                credentialsClient.ping(
                        mapOf(AUTHORIZATION_HEADER to authorizationHeaderValue(apiKey, password)),
                        this.createURI()
                )
            }
}