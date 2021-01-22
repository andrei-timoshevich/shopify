package com.ecommerce.shopify.model.product

import com.ecommerce.shopify.model.BaseGuidEntity
import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import javax.persistence.Entity

@Entity
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ProductVariant(

    @set:JsonAlias("id")
    var variantId: Long? = null,
    var price: Float? = null,
    @set:JsonAlias("inventory_item_id")
    var inventoryId: Long? = null,
    @set:JsonAlias("inventory_quantity")
    var quantity: Long? = null,
    var position: Long? = null,
    var sku: String? = null,
    var title: String? = null,
    @set:JsonAlias("requires_shipping")
    var requiresShipping: Boolean = false,
    var grams: Long? = null,
    var weight: Float? = null,
    var image: String? = null,
    @Transient
    @set:JsonAlias("image_id")
    var imageId: Long? = null
) : BaseGuidEntity()