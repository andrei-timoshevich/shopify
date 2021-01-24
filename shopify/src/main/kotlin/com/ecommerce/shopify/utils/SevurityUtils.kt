package com.ecommerce.shopify.utils

import com.ecommerce.shopify.model.Credentials
import org.springframework.util.Base64Utils
import java.net.URI

const val AUTHORIZATION_HEADER = "Authorization"
fun Credentials.createURI() = URI("https://$store.myshopify.com")
fun authorizationHeaderValue(apiKey: String, password: String) =
        "Basic " + Base64Utils.encodeToString("$apiKey:$password".toByteArray())