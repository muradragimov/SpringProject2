package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import java.time.LocalDateTime
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp

@Entity
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var transactionType: TransactionType? = TransactionType.INITIAL,

    var amount: BigDecimal? = null,

    @CreationTimestamp
    var transactionTime: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    var account: Account? = null,

){

}

enum class TransactionType {
    INITIAL, TRANSFER
}