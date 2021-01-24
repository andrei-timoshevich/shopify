package com.ecommerce.shopify.repository

import com.ecommerce.shopify.model.product.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>