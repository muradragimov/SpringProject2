package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-10T13:51:01+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
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

        accountEntity.setUsername( accountDto.getUsername() );
        accountEntity.setPassword( accountDto.getPassword() );
        if ( accountDto.isActive() != null ) {
            accountEntity.setActive( accountDto.isActive() );
        }

        return accountEntity;
    }

    @Override
    public AccountDto mapToDto(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        String username = null;
        String password = null;

        username = accountEntity.getUsername();
        password = accountEntity.getPassword();

        Boolean isActive = null;

        AccountDto accountDto = new AccountDto( username, password, isActive );

        accountDto.setActive( accountEntity.isActive() );

        return accountDto;
    }
}
