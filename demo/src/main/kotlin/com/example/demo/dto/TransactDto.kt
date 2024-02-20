package com.example.demo.dto

import com.example.demo.model.Account
import com.example.demo.model.TransactionType
import java.math.BigDecimal

data class TransactDto (

    var transactionType: TransactionType? = TransactionType.INITIAL,

    var amount: BigDecimal? = null,

    var currency: String? = null,

    var accountDto: AccountDto? = null
)