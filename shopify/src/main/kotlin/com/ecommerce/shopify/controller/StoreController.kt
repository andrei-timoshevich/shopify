package com.ecommerce.shopify.controller

import com.ecommerce.shopify.model.Credentials
import com.ecommerce.shopify.service.StoreService
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping("/store")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"], methods = [GET, POST, PUT])
class StoreController(private val storeService: StoreService) {

    @PostMapping("/credentials/check")
    fun checkCredentials(@RequestBody credentials: Credentials) = storeService.validateCredentials(credentials)

    @PostMapping("/credentials/save")
    fun saveCredentials(@RequestBody credentials: Credentials) = storeService.saveCredentials(credentials)
}