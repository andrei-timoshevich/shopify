package com.ecommerce.shopify.model

import com.ecommerce.shopify.config.listener.UuidListener
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY
import java.util.UUID
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(UuidListener::class)
abstract class BaseGuidEntity(

    @Column(nullable = false, columnDefinition = "BINARY(16)")
    @set:JsonProperty(access = READ_ONLY)
    open var guid: UUID? = null

) : BaseEntity()
