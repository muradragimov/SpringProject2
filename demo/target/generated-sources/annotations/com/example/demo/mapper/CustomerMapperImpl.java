package com.example.demo.mapper;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-20T10:49:24+0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public List<CustomerDto> mapToDtos(List<Customer> studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( studentEntity.size() );
        for ( Customer customer : studentEntity ) {
            list.add( mapToDto( customer ) );
        }

        return list;
    }

    @Override
    public Customer mapToEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerDto.getName() );
        customer.setSurname( customerDto.getSurname() );

        return customer;
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
