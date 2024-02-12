package com.example.demo.service

import com.example.demo.dto.TransactionDto
import com.example.demo.mapper.AccountMapper
import com.example.demo.mapper.TransactionMapper
import com.example.demo.model.AccountEntity
import com.example.demo.model.CustomerEntity
import com.example.demo.repository.AccountRepository
import org.springframework.stereotype.Service
import java.util.NoSuchElementException

@Service
class AccountService (
    val repository: AccountRepository
){
    fun doTransaction(transactionDto: TransactionDto, id: Long ){
        val accountEntity : AccountEntity =
         AccountMapper.INSTANCE.transact(transactionDto, getElemetById(id))
        repository.save(accountEntity)
    }

    private fun getElemetById(id: Long): AccountEntity {
        return repository.findById(id)
            .orElseThrow { NoSuchElementException("Not found") }
    }
}