package com.example.demo.controller;

import com.example.demo.dto.TransactionDto;
import com.example.demo.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping("/{id}")
    public void save(@RequestBody @Valid TransactionDto transactionDto, @PathVariable Long id){
        accountService.doTransaction(transactionDto, id);
    }
}
