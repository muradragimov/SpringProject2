package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "accounts")
data class Account (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "balance", length = 100)
    var balance: BigDecimal? = BigDecimal.ZERO,

    @CreationTimestamp
    var creationDate : LocalDateTime? = null,

    @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL])
    var transactions : MutableList<Transact>? = mutableListOf(),

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    var customer: Customer? = null
){
}