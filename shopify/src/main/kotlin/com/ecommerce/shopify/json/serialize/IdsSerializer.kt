package com.ecommerce.shopify.json.serialize

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider

class IdsSerializer : JsonSerializer<Set<Long>?>() {

    override fun serialize(value: Set<Long>?, generator: JsonGenerator, provider: SerializerProvider) {
        return generator.writeString(value?.joinToString(COMMA))
    }

    companion object {
        private const val COMMA = ","
    }
}