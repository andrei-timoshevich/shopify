package com.ecommerce.shopify.controller

import com.ecommerce.shopify.model.Credentials
import com.ecommerce.shopify.service.StoreService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RequestMethod.PUT
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/store")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"], methods = [GET, POST, PUT])
class StoreController(private val storeService: StoreService) {

    @PostMapping("/ping")
    fun checkCredentials(@RequestBody credentials: Credentials) = storeService.validateCredentials(credentials)
}