package com.ecommerce.shopify.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.DateSerializer
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.util.Date
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity(

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = IDENTITY)
    open var id: Long? = null,

    @CreatedDate
    @set:JsonProperty(access = READ_ONLY)
    @get:JsonSerialize(using = DateSerializer::class)
    open var created: Date? = null,

    @LastModifiedDate
    @set:JsonProperty(access = READ_ONLY)
    @get:JsonSerialize(using = DateSerializer::class)
    open var updated: Date? = null

) : Serializable