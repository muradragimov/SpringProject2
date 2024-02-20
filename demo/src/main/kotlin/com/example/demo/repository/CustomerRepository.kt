package com.example.demo.repository

import com.example.demo.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface CustomerRepository : JpaRepository<Customer, Long> {
    fun getEntityByName(name: String?): Optional<Customer?>?
    fun deleteByName(name: String?)
}