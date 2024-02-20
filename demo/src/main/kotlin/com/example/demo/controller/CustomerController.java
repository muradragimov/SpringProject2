package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<CustomerDto> get() {
        return service.findAll();
    }

    @PostMapping
    public void add(@RequestBody CustomerDto customerDto) {
        service.save(customerDto);
    }

    @PutMapping("/{id}")
    public void setAccount(@RequestBody @Valid AccountDto accountDto, @PathVariable Integer id) {
        service.update(accountDto, id);
    }

}
