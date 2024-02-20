package com.example.demo.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "customers")
class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "customer_name", length = 100)
    var name: String? = null,

    @Column(name = "customer_surname", length = 100)
    var surname: String? = null,

    @CreationTimestamp
    var createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null,

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL])
    var accounts: MutableList<Account>? = mutableListOf()
)