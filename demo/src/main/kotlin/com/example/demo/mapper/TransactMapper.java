package com.example.demo.mapper;

import com.example.demo.dto.TransactDto;
import com.example.demo.model.Transact;
import com.example.demo.model.Transact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactMapper {
    TransactMapper TRANSACTION_MAPPER = Mappers.getMapper(TransactMapper.class);

    List<TransactDto> mapToDtos(List<Transact> transactionEntities);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "transactionTime", ignore = true)
    })
    Transact mapToEntity(TransactDto transactDto);

    TransactDto mapToDto(Transact transactionEntity);
}
