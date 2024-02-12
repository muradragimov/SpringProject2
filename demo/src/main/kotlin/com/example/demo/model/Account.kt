package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "Accounts")
data class Account (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "balance", length = 100)
    var balance: BigDecimal? = BigDecimal.ZERO,

    @CreationTimestamp
    var creationDate : LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    var customer: Customer? = null,

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    var transactions : MutableList<Transaction>? = mutableListOf()
){
}