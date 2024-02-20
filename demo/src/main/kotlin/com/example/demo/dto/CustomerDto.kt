package com.example.demo.dto

import com.fasterxml.jackson.annotation.JsonIgnore


data class CustomerDto (

    var name: String?,

    var surname: String?,

    @JsonIgnore
    var accountDtos: MutableList<AccountDto>?
)