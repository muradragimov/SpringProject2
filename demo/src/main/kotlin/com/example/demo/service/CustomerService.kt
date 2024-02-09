package com.example.demo.service

import com.example.demo.dto.CustomerDto
import com.example.demo.mapper.CustomerMapper
import com.example.demo.model.CustomerEntity
import com.example.demo.repository.AccountRepository
import com.example.demo.repository.CustomerRepository
import org.springframework.data.jpa.domain.AbstractPersistable_
import org.springframework.stereotype.Service
import java.util.*


@Service
class CustomerService (
    private val repository: CustomerRepository
){

    fun findAll(){
        repository.findAll();
    }

    fun save(customerDto: CustomerDto){
        val customerEntity : CustomerEntity = CustomerMapper.INSTANCE.mapToEntity(customerDto)
        repository.save(customerEntity)
    }

    fun update(customerDto: CustomerDto, id: Long){
        val teacherEntity: CustomerEntity =
            CustomerMapper.INSTANCE.buildEntity(customerDto, getElemetById(id))
        repository.save(teacherEntity)
    }

    private fun getElemetById(id: Long): CustomerEntity {
        return repository.findById(id)
            .orElseThrow { NoSuchElementException("Not found") }
    }

}