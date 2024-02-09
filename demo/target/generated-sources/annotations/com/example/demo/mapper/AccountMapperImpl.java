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
    date = "2024-02-09T16:05:14+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public List<AccountDto> mapToDtos(List<AccountEntity> accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accountEntity.size() );
        for ( AccountEntity accountEntity1 : accountEntity ) {
            list.add( mapToDto( accountEntity1 ) );
        }

        return list;
    }

    @Override
    public AccountEntity mapToEntity(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        return accountEntity;
    }

    @Override
    public AccountDto mapToDto(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        String username = null;
        String password = null;
        CustomerDto customer = null;

        username = accountEntity.getUsername();
        password = accountEntity.getPassword();
        customer = customerEntityToCustomerDto( accountEntity.getCustomer() );

        boolean isActive = false;

        AccountDto accountDto = new AccountDto( username, password, isActive, customer );

        return accountDto;
    }

    protected CustomerDto customerEntityToCustomerDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        String name = null;
        List<AccountDto> accounts = null;

        name = customerEntity.getName();
        accounts = mapToDtos( customerEntity.getAccounts() );

        String surname = null;
        String email = null;
        String password = null;

        CustomerDto customerDto = new CustomerDto( name, surname, email, password, accounts );

        return customerDto;
    }
}
