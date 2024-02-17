package com.example.demo.model

import jakarta.persistence.*

@Entity
class AccountEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "AccountUsername", length = 100)
    var username: String? = null,

    @Column(name = "AccountPassword", length = 100)
    var password: String? = null,

    @Column(name = "isActive", length = 100)
    var isActive: Boolean = true,

    @OneToMany(mappedBy = "accountEntity", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var transactions : MutableList<TransactionEntity>? = mutableListOf(),

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    var accountEntity: CustomerEntity? = null
){
}