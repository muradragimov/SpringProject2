package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.model.Account;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-12T13:29:03+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public List<AccountDto> mapToDtos(List<Account> accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        List<AccountDto> list = new ArrayList<AccountDto>( accountEntity.size() );
        for ( Account account : accountEntity ) {
            list.add( mapToDto( account ) );
        }

        return list;
    }

    @Override
    public Account mapToEntity(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setBalance( accountDto.getBalance() );

        return account;
    }

    @Override
    public AccountDto mapToDto(Account account) {
        if ( account == null ) {
            return null;
        }

        BigDecimal balance = null;

        balance = account.getBalance();

        CustomerDto customerDto = null;
        List<TransactionDto> transactionDtos = null;

        AccountDto accountDto = new AccountDto( balance, customerDto, transactionDtos );

        return accountDto;
    }
}
