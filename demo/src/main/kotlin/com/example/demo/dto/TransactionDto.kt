package com.example.demo.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
    var amount: BigDecimal? = null,
    var currency: String? = null
)
