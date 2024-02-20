package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.TransactDto;
import com.example.demo.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/accounts")
public class AccountController {

    private AccountService service;

    public AccountController(AccountService accountService) {
        this.service = accountService;
    }

    @GetMapping
    public List<AccountDto> getAll(){
        return service.getAll();
    }

    @PostMapping
    public AccountDto save(@RequestBody @Valid AccountDto accountDto){
        return service.save(accountDto);
    }

    @PutMapping("/{id}")
    public void setTransaction(@RequestBody @Valid TransactDto transactionDto, @PathVariable Long id){
        service.doTransaction(transactionDto, id);
    }

}
