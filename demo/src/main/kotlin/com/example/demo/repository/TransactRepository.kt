package com.example.demo.repository

import com.example.demo.model.Transact
import org.springframework.data.jpa.repository.JpaRepository

interface TransactRepository : JpaRepository<Transact, Long> {
}