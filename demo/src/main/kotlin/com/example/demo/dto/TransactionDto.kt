package com.example.demo.dto

import com.example.demo.model.Account
import com.example.demo.model.TransactionType
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(

    var transactionType: TransactionType? = TransactionType.INITIAL,

    var amount: BigDecimal? = null,

    @JsonIgnore
    var account: Account? = null,
)
