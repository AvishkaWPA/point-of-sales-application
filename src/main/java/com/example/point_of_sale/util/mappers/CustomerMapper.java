package com.example.point_of_sale.util.mappers;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    List<CustomerDTO> customerEntityListToDtoList(List<Customer> customers);
}
