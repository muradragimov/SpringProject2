package com.example.demo.service

import com.example.demo.dto.AccountDto
import com.example.demo.dto.CustomerDto
import com.example.demo.exception.NotFoundException
import com.example.demo.mapper.AccountMapper
import com.example.demo.mapper.CustomerMapper
import com.example.demo.model.Customer
import com.example.demo.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerService (
    private val repository: CustomerRepository
){
    fun findAll () : List<CustomerDto>{
       val customers : List<Customer> = repository.findAll()

       val customerDtos : List<CustomerDto> = customers.map {customer ->

               CustomerDto(
                   name = customer.name,
                   surname = customer.surname,
                   accountDtos = AccountMapper.INSTANCE.mapToDtos(customer.accounts)
               )

       }
       return customerDtos;
    }

    fun save(customerDto: CustomerDto){
        val customerEntity : Customer = CustomerMapper.INSTANCE.mapToEntity(customerDto)
        repository.save(customerEntity)
    }

    fun update(accountDto: AccountDto, id: Long){
        val customerEntity: Customer =
            CustomerMapper.INSTANCE.buildEntity(accountDto, getElemetById(id))

        repository.save(customerEntity)
    }

    private fun getElemetById(id: Long): Customer {
        return repository.findById(id)
            .orElseThrow { NotFoundException("Not found") }
    }

}