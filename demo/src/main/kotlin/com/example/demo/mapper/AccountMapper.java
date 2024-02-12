package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    List<AccountDto> mapToDtos(List<Account> accountEntity);

    @Mappings(value = {
            @Mapping(target = "id", ignore =true),
            @Mapping(target = "creationDate", ignore = true)
    })
    Account mapToEntity(AccountDto accountDto);

    AccountDto mapToDto(Account account);

    default Account transact(TransactionDto transactionDto, Account accountEntity){

        accountEntity.getTransactions().add(TransactionMapper.TRANSACTION_MAPPER.mapToEntity(transactionDto));

        return accountEntity;
    }
}
