package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.CustomerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-10T13:51:01+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public List<CustomerDto> mapToDtos(List<CustomerEntity> studentEntity) {
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
        if ( customerDto == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName( customerDto.getName() );

        return customerEntity;
    }

    @Override
    public CustomerDto mapToDto(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        String name = null;

        name = customerEntity.getName();

        CustomerDto customerDto = new CustomerDto( name );

        return customerDto;
    }
}
