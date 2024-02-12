package com.example.demo.service

import com.example.demo.dto.AccountDto
import com.example.demo.dto.TransactionDto
import com.example.demo.exception.NotFoundException
import com.example.demo.mapper.AccountMapper
import com.example.demo.model.Account
import com.example.demo.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService (
    val repository: AccountRepository
){
    fun getAll() : List<AccountDto>{
        val accountDtos : List<AccountDto> = AccountMapper.INSTANCE.mapToDtos(repository.findAll())
        return accountDtos;
    }

    fun save(accountDto : AccountDto): AccountDto{
        val account : Account = AccountMapper.INSTANCE.mapToEntity(accountDto)
        repository.save(account)
        return accountDto
    }

    fun doTransaction(transactionDto: TransactionDto, id: Long ){
        val accountEntity : Account =
         AccountMapper.INSTANCE.transact(transactionDto, getElemetById(id))
        repository.save(accountEntity)
    }

    private fun getElemetById(id: Long): Account {
        return repository.findById(id)
            .orElseThrow { NotFoundException("GIVEN_ELEMENT") }
    }
}