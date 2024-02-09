package com.example.demo.repository

import com.example.demo.model.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface CustomerRepository : JpaRepository<CustomerEntity, Long> {
    fun getStudentEntityByName(name: String?): Optional<CustomerEntity?>?
    fun deleteByName(name: String?)
}