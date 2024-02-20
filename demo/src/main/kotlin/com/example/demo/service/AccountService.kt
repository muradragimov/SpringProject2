package com.example.demo.service

import com.example.demo.dto.AccountDto
import com.example.demo.dto.TransactDto
import com.example.demo.exception.NotFoundException
import com.example.demo.mapper.AccountMapper
import com.example.demo.mapper.CustomerMapper
import com.example.demo.mapper.TransactMapper
//import com.example.demo.mapper.CustomerMapper
import com.example.demo.model.Account
import com.example.demo.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService (
    val repository: AccountRepository
){
    fun getAll() : List<AccountDto>{
        val accounts : List<Account> = repository.findAll()

        val accountDtos: List<AccountDto> = accounts.map { account ->
            AccountDto(
                balance = account.balance,
                customerDto = CustomerMapper.INSTANCE.mapToDto(account.customer),
                transactionDtos = TransactMapper.TRANSACTION_MAPPER.mapToDtos(account.transactions)
            )
        }
        return accountDtos;
    }

    fun save(accountDto : AccountDto): AccountDto{

        val account : Account = AccountMapper.INSTANCE.mapToEntity(accountDto)

        account.customer = CustomerMapper.INSTANCE.mapToEntity(accountDto.customerDto)

        print("*************" + account)

        repository.save(account)

        return accountDto
    }

    fun doTransaction(transactionDto: TransactDto, id: Long ){
        val accountEntity : Account =
         AccountMapper.INSTANCE.transact(transactionDto, getElemetById(id))

        repository.save(accountEntity)
    }

    private fun getElemetById(id: Long): Account {
        return repository.findById(id)
            .orElseThrow { NotFoundException("GIVEN_ELEMENT") }
    }
}