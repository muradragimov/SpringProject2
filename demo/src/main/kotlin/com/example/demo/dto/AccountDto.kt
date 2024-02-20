package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal

data class AccountDto(

    var balance: BigDecimal?,

    var customerDto: CustomerDto?,

    @JsonIgnore
    var transactionDtos : MutableList<TransactDto>? = mutableListOf()
)