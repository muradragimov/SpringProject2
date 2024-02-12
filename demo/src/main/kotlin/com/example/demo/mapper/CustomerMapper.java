package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    List<CustomerDto> mapToDtos(List<Customer> studentEntity);

    @Mappings(value = {
            @Mapping(target = "id", ignore =true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    Customer mapToEntity(CustomerDto customerDto);

    CustomerDto mapToDto(Customer customerEntity);

    default Customer buildEntity(AccountDto accountDto, Customer customerEntity){

        Account accountEntity = AccountMapper.INSTANCE.mapToEntity(accountDto);

        customerEntity.getAccounts().add(accountEntity);

        System.out.println(customerEntity.getAccounts());

        return customerEntity;
    }
}
