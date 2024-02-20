package com.example.demo.mapper;

import com.example.demo.dto.TransactDto;
import com.example.demo.model.Transact;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-18T13:48:35+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class TransactMapperImpl implements TransactMapper {

    @Override
    public List<TransactDto> mapToDtos(List<Transact> transactionEntities) {
        if ( transactionEntities == null ) {
            return null;
        }

        List<TransactDto> list = new ArrayList<TransactDto>( transactionEntities.size() );
        for ( Transact transact : transactionEntities ) {
            list.add( mapToDto( transact ) );
        }

        return list;
    }

    @Override
    public Transact mapToEntity(TransactDto transactDto) {
        if ( transactDto == null ) {
            return null;
        }

        Transact transact = new Transact();

        transact.setAmount( transactDto.getAmount() );

        return transact;
    }

    @Override
    public TransactDto mapToDto(Transact transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }

        TransactDto transactDto = new TransactDto();

        transactDto.setAmount( transactionEntity.getAmount() );

        return transactDto;
    }
}
