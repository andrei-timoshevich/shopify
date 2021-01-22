package com.ecommerce.shopify.config.listener

import com.ecommerce.shopify.model.BaseGuidEntity
import java.util.UUID.randomUUID
import javax.persistence.PrePersist
import javax.persistence.PreUpdate

class UuidListener {

    @PrePersist
    fun BaseGuidEntity.touchForCreate() = run {
        guid = guid ?: randomUUID()
    }

    @PreUpdate
    fun BaseGuidEntity.touchForUpdate() = Unit

}