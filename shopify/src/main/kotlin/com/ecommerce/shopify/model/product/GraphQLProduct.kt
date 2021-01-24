package com.ecommerce.shopify.model.product;

import com.ecommerce.shopify.json.deserializer.GraphQLProductIdDeserializer
import com.ecommerce.shopify.json.deserializer.GraphQLProductImageDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.io.Serializable

@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GraphQLProductData(
        @set:JsonProperty("data")
        var data: GraphQLProductNode? = null
) : Serializable

@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GraphQLProductNode(
        @set:JsonProperty("products")
        var products: GraphQLProductEdgesResponse? = null
) : Serializable

@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GraphQLProductEdgesResponse(
        @set:JsonProperty("edges")
        var edges: List<GraphQLProductNodeNode?>? = null
) : Serializable

@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GraphQLProductNodeNode(
        @set:JsonProperty("node")
        var node: GraphQLProduct? = null
) : Serializable

@JsonInclude(NON_EMPTY)
@JsonRootName("node")
@JsonIgnoreProperties(ignoreUnknown = true)
data class GraphQLProduct(
        @set:JsonProperty("id")
        @set:JsonDeserialize(using = GraphQLProductIdDeserializer::class)
        var productId: Long? = null,
        @set:JsonProperty("title")
        var title: String? = null,
        @set:JsonProperty("tags")
        var tags: List<String?>? = null,
        @set:JsonProperty("productType")
        var type: String? = null,
        @set:JsonProperty("images")
        @set:JsonDeserialize(using = GraphQLProductImageDeserializer::class)
        var image: String? = null
) : Serializable
