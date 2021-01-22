package com.ecommerce.shopify.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Entity
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Credentials(
    @get:NotNull
    var apiKey: String,
    @get:NotNull
    var password: String,
    @get:NotNull
    var store: String
) : BaseGuidEntity()