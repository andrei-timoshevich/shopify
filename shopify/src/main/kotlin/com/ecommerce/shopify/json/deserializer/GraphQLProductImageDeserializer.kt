package com.ecommerce.shopify.json.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

class GraphQLProductImageDeserializer : JsonDeserializer<String?>() {

    override fun deserialize(parser: JsonParser?, conext: DeserializationContext?) =
            ObjectMapper().readTree<JsonNode>(parser)?.get(EDGES)?.first()?.get(NODE)?.get(SRC)?.asText()

    companion object {
        private const val EDGES = "edges"
        private const val NODE = "node"
        private const val SRC = "originalSrc"
    }
}