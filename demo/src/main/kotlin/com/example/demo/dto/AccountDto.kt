package com.example.demo.dto

import com.example.demo.model.Customer
import com.example.demo.model.Transaction
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class AccountDto(

    var balance: BigDecimal?,

    var customerDto: CustomerDto? = null,

    @JsonIgnore
    var transactionDtos : MutableList<TransactionDto>? = mutableListOf()
)