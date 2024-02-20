package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "transacts")
class Transact (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var amount: BigDecimal? = null,

    var currency: String? = null,

    var transactionType: TransactionType? = TransactionType.INITIAL,

    @CreationTimestamp
    var transactionTime: LocalDateTime? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    var account: Account? = null
)

enum class TransactionType {
    INITIAL, TRANSFER
}