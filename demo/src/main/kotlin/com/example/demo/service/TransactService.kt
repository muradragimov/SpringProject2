package com.example.demo.service

import com.example.demo.dto.AccountDto
import com.example.demo.dto.TransactDto
import com.example.demo.mapper.AccountMapper
import com.example.demo.mapper.CustomerMapper
import com.example.demo.mapper.TransactMapper
import com.example.demo.model.Transact
import com.example.demo.repository.TransactRepository
import org.springframework.stereotype.Service

@Service
class TransactService (
    var repository: TransactRepository
){

    fun save(transactionDto: TransactDto): TransactDto {

        val transaction: Transact = TransactMapper.TRANSACTION_MAPPER.mapToEntity(transactionDto)

        transaction.account = AccountMapper.INSTANCE.mapToEntity(transactionDto.accountDto)

        transaction.account?.customer = CustomerMapper.INSTANCE.mapToEntity(transactionDto.accountDto?.customerDto)

        repository.save(transaction)

        return transactionDto
    }
}