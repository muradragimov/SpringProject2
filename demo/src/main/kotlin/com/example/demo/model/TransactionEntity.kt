package com.example.demo.model

import java.math.BigDecimal
import java.time.LocalDateTime
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp

@Entity
data class TransactionEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var amount: BigDecimal? = null,

    var currency: String? = null,

    @CreationTimestamp
    var transactionTime: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    var accountEntity: AccountEntity? = null
)
