package com.example.point_of_sale.service;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomerByActiveState(boolean state);

    public String saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);
}
