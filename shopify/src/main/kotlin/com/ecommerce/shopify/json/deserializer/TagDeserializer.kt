package com.ecommerce.shopify.json.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

class TagDeserializer : JsonDeserializer<List<String?>?>() {

    override fun deserialize(parser: JsonParser, context: DeserializationContext?): List<String?>? {
        return parser.valueAsString.split(COMMA)
    }

    companion object {
        private const val COMMA = ","
    }
}