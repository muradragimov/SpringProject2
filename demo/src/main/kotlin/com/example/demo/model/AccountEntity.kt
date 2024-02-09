package com.example.demo.model

import jakarta.persistence.*

@Entity
class AccountEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "AccountUsername", length = 100)
    val username: String? = null,

    @Column(name = "AccountPassword", length = 100)
    val password: String? = null,

    @Column(name = "isActive", length = 100)
    val isActive: Boolean = true,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: CustomerEntity? = null
){
}