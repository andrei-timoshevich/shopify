package com.ecommerce.shopify.model.product

import com.ecommerce.shopify.json.deserializer.ImageDeserializer
import com.ecommerce.shopify.json.deserializer.ImagesDeserializer
import com.ecommerce.shopify.json.deserializer.TagDeserializer
import com.ecommerce.shopify.model.BaseGuidEntity
import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import javax.persistence.CascadeType.ALL
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
@JsonInclude(NON_EMPTY)
@JsonRootName("product")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Product(

    @get:JsonAlias("product_id")
    var productId: Long? = null,
    @ElementCollection
    @set:JsonDeserialize(using = TagDeserializer::class)
    var tags: Set<String?>? = null,
    var title: String? = null,
    var vendor: String? = null,
    @OneToMany(cascade = [ALL], orphanRemoval = true)
    var variants: Set<ProductVariant>? = null,
    @set:JsonDeserialize(using = ImageDeserializer::class)
    var image: String? = null,
    @Transient
    @get:JsonIgnore
    @set:JsonDeserialize(using = ImagesDeserializer::class)
    var images: Map<Long?, String?>? = null

) : BaseGuidEntity()