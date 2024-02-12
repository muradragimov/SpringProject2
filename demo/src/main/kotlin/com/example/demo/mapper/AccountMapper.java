package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.model.AccountEntity;
import com.example.demo.model.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    List<AccountDto> mapToDtos(List<AccountEntity> accountEntity);

    @Mappings(value = {
            @Mapping(target = "id", ignore =true)
    })
    AccountEntity mapToEntity(AccountDto accountDto);

    AccountDto mapToDto(AccountEntity accountEntity);

    default AccountEntity transact(TransactionDto transactionDto, AccountEntity accountEntity){

        accountEntity.getTransactions().add(TransactionMapper.TRANSACTION_MAPPER.mapToEntity(transactionDto));

        return accountEntity;
    }
}
