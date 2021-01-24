package com.ecommerce.shopify.model.product

import com.ecommerce.shopify.json.serialize.IdsSerializer
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.io.Serializable

@JsonInclude(NON_EMPTY)
data class GetProductRequest(
        @get:JsonSerialize(using = IdsSerializer::class)
        var ids: Set<Long>? = null,
        var limit: Int? = null
) : Serializable