package com.example.demo.dto

import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

class AccountDto(

    var username: String?,

    var password: String?,

    var isActive: Boolean? = true,

)