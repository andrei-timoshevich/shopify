@file:JvmName("JsonUtils")

package com.ecommerce.shopify.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT
import com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
import com.fasterxml.jackson.databind.type.CollectionType
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule


const val EMPTY_TEMPLATE = "{ }"

private val _knownListTypes = mutableMapOf<Class<*>, CollectionType>()

fun ObjectMapper.configureMapper() = apply {
    enable(INDENT_OUTPUT)
    disable(WRITE_DATES_AS_TIMESTAMPS)
    registerModule(JavaTimeModule())
}

private val _mapper = ObjectMapper().configureMapper()

fun mapper() = _mapper