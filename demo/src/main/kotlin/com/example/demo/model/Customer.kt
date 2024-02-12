package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "Customers")
class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "CustomerName", length = 100)
    var name: String? = null,

    @Column(name = "CustomerSurname", length = 100)
    var surname: String? = null,

    @CreationTimestamp
    var createdAt: LocalDateTime? = null,

    @UpdateTimestamp
    var updatedAt: LocalDateTime? = null,

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    var accounts: MutableList<Account>? = mutableListOf()
)