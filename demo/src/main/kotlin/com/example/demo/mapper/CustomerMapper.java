package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.AccountEntity;
import com.example.demo.model.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    List<CustomerDto> mapToDtos(List<CustomerEntity> studentEntity);

    @Mappings(value = {
            @Mapping(target = "id", ignore =true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    CustomerEntity mapToEntity(CustomerDto customerDto);

    CustomerDto mapToDto(CustomerEntity customerEntity);

    default CustomerEntity buildEntity(AccountDto accountDto, CustomerEntity customerEntity){

        AccountEntity accountEntity = AccountMapper.INSTANCE.mapToEntity(accountDto);

        customerEntity.getAccounts().add(accountEntity);

        return customerEntity;
    }
}
