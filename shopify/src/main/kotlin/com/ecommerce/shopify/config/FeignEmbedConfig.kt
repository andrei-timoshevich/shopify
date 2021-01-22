package com.ecommerce.shopify.config

import com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_ROOT_VALUE
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

class FeignEmbedConfig {

    @Bean
    fun decoder() = ResponseEntityDecoder(SpringDecoder {
        HttpMessageConverters(MappingJackson2HttpMessageConverter(ObjectMapper().enable(UNWRAP_ROOT_VALUE)))
    })
}