package com.ecommerce.shopify.repository

import com.ecommerce.shopify.model.Credentials
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CredentialsRepository : JpaRepository<Credentials, Long> {

    fun findTopByOrderByIdDesc(): Credentials
}