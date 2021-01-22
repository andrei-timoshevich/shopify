package com.ecommerce.shopify.json.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

class ImagesDeserializer : JsonDeserializer<Map<Long?, String?>?>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext?): Map<Long?, String?> {
        return ObjectMapper().readTree<JsonNode>(parser).mapNotNull {
            it.get(ID).asLong() to it.get(SRC).asText()
        }.toMap()
    }

    companion object {
        private const val SRC = "src"
        private const val ID = "id"
    }
}