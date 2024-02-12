package com.example.demo.service

import com.example.demo.dto.AccountDto
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

    fun findAll () : List<CustomerDto>{
       val customerDtos : List<CustomerDto> = CustomerMapper.INSTANCE.mapToDtos(repository.findAll())
       return customerDtos;
    }

    fun save(customerDto: CustomerDto){
        val customerEntity : CustomerEntity = CustomerMapper.INSTANCE.mapToEntity(customerDto)
        repository.save(customerEntity)
    }

    fun update(accountDto: AccountDto, id: Long){
        val customerEntity: CustomerEntity =
            CustomerMapper.INSTANCE.buildEntity(accountDto, getElemetById(id))

        repository.save(customerEntity)
    }

    private fun getElemetById(id: Long): CustomerEntity {
        return repository.findById(id)
            .orElseThrow { NoSuchElementException("Not found") }
    }

}