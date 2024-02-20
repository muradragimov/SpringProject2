package com.example.demo.controller;

import com.example.demo.dto.TransactDto;
import com.example.demo.service.TransactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transactions")
public class TransactController {

    @Autowired
    private TransactService transactionService;

    @PostMapping
    public void save(@RequestBody @Valid TransactDto transactionDto){
        transactionService.save(transactionDto);
    }
}
