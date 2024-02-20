package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-20T10:27:22+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class CustomersMapperImpl implements CustomerMapper {

    @Override
    public List<CustomerDto> mapToDtos(List<Customer> studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( studentEntity.size() );
        for ( Customer customers : studentEntity ) {
            list.add( mapToDto( customers ) );
        }

        return list;
    }

    @Override
    public Customer mapToEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customers = new Customer();

        customers.setName( customerDto.getName() );
        customers.setSurname( customerDto.getSurname() );

        return customers;
    }

    @Override
    public CustomerDto mapToDto(Customer customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        String name = null;
        String surname = null;

        name = customerEntity.getName();
        surname = customerEntity.getSurname();

        List<AccountDto> accountDtos = null;

        CustomerDto customerDto = new CustomerDto( name, surname, accountDtos );

        return customerDto;
    }
}
