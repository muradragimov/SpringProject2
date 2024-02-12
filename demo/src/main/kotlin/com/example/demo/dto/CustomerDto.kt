package com.example.demo.dto

import com.example.demo.model.Account
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length


data class CustomerDto (

    var name: String?,

    var surname: String?,

    var accountDtos: MutableList<AccountDto>?
)