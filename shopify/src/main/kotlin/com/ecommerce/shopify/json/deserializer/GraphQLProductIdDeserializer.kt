package com.ecommerce.shopify.json.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper

class GraphQLProductIdDeserializer : JsonDeserializer<Long?>() {

    override fun deserialize(parser: JsonParser?, context: DeserializationContext?)
       = ObjectMapper().readTree<JsonNode>(parser)?.asText()?.substringAfterLast(DELIMITER)?.toLong()

    companion object{
        private const val DELIMITER = "/"
    }
}