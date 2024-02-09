package com.example.demo.dto

import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

data class AccountDto(
    @NotBlank(message = "Username cannot be blank")
    val username: String,

    @NotBlank(message = "Password cannot be blank")
    val password: String,

    val isActive: Boolean = true,

    val customer: CustomerDto
)