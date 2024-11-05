package com.example.point_of_sale.service.impl;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.dto.request.CustomerUpdateDTO;
import com.example.point_of_sale.entity.Customer;
import com.example.point_of_sale.repo.CustomerRepo;
import com.example.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<CustomerDTO> getAllCustomerByActiveState(boolean state) {
        List<Customer> customers = customerRepo.findAllByActiveEquals(state);

        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for(Customer customer:customers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOS.add(customerDTO);
        }

        return customerDTOS;
    }

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumbers(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return "";
    }

    @Override
    public void updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerId(customerUpdateDTO.getCustomerId());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customerRepo.save(customer);

        }
        else throw new RuntimeException("Not found id");
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;
        }
        else{
            throw new RuntimeException("Not found a customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepo.findAll();

        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer:allCustomers){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getCustomerSalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "deleted successfully " + customerId;
        } else throw new RuntimeException("No customer found");
    }
}
