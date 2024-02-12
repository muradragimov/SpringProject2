package com.example.demo.mapper;

import com.example.demo.dto.TransactionDto;
import com.example.demo.model.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper {

    TransactionMapper TRANSACTION_MAPPER = Mappers.getMapper(TransactionMapper.class);

    List<TransactionDto> mapToDtos(List<TransactionEntity> transactionEntities);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true)
    })
    TransactionEntity mapToEntity(TransactionDto transactionDto);

    TransactionDto mapToDto(TransactionEntity transactionEntity);
}
