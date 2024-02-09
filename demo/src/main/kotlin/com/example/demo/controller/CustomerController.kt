package com.example.demo.controller

import com.example.demo.dto.CustomerDto
import com.example.demo.model.CustomerEntity
import com.example.demo.service.CustomerService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/abouts")
class CustomerController (
    private val service: CustomerService
){

    @GetMapping
    fun get(){
        service.findAll()
    }

    @PostMapping
    fun add(@RequestBody @Valid customerDto: CustomerDto){
        service.save(customerDto)
    }
}