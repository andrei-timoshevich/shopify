package com.ecommerce.shopify.controller

import com.ecommerce.shopify.service.ProductService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RequestMethod.PUT
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"], methods = [GET, POST, PUT])
class ProductController(private val productService: ProductService) {

    @GetMapping("/import/{id}")
    fun importProduct(@PathVariable id: Long) = productService.importProduct(id)

    //todo add pagination
    @PostMapping("/search")
    fun searchProduct(@RequestParam title: String) = productService.searchProductByTitle(title)
}