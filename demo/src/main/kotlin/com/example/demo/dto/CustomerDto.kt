package com.example.demo.dto

import jakarta.persistence.Column
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length


data class CustomerDto (

    var name: String ?,

    var surname: String ?,

    var email: String ?,

    var password: String ?,

    var accounts : List<AccountDto>
    ){
    init {
        requireNotNull(name) { "Name must not be null" }
        requireNotNull(email) { "Email must not be null" }
    }
}