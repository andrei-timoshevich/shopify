package com.ecommerce.shopify.json.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

class ImageDeserializer : JsonDeserializer<String?>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext?): String? {
        return ObjectMapper().readTree<JsonNode>(parser).get(SRC).asText()
    }

    companion object {
        private const val SRC = "src"
    }
}