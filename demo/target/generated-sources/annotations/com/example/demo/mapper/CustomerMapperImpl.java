package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.AccountEntity;
import com.example.demo.model.CustomerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-09T15:51:35+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public List<CustomerDto> mapToDto(List<CustomerEntity> studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( studentEntity.size() );
        for ( CustomerEntity customerEntity : studentEntity ) {
            list.add( mapToDto( customerEntity ) );
        }

        return list;
    }

    @Override
    public CustomerEntity mapToEntity(CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto mapToDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        String name = null;
        List<AccountDto> accounts = null;

        name = customerEntity.getName();
        accounts = accountEntityListToAccountDtoList( customerEntity.getAccounts() );

        String surname = null;
        String email = null;
        String password = null;

        CustomerDto customerDto = new CustomerDto( name, surname, email, password, accounts );

        return customerDto;
    }

    @Override
    public CustomerEntity buildEntity(CustomerDto customerDto, CustomerEntity customerEntity) {
        return CustomerMapper.super.buildEntity(customerDto, customerEntity);
    }

    protected AccountDto accountEntityToAccountDto(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        String username = null;
        String password = null;

        username = accountEntity.getUsername();
        password = accountEntity.getPassword();

        boolean isActive = false;

        AccountDto accountDto = new AccountDto( username, password, isActive );

        return accountDto;
    }

    protected List<AccountDto> accountEntityListToAccountDtoList(List<AccountEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AccountDto> list1 = new ArrayList<AccountDto>( list.size() );
        for ( AccountEntity accountEntity : list ) {
            list1.add( accountEntityToAccountDto( accountEntity ) );
        }

        return list1;
    }
}
