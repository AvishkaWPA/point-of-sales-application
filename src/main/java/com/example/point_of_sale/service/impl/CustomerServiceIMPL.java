package com.example.point_of_sale.service.impl;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.dto.request.CustomerUpdateDTO;
import com.example.point_of_sale.entity.Customer;
import com.example.point_of_sale.exception.Exception;
import com.example.point_of_sale.exception.NotFoundException;
import com.example.point_of_sale.repo.CustomerRepo;
import com.example.point_of_sale.service.CustomerService;
import com.example.point_of_sale.util.mappers.CustomerMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomerByActiveState(boolean state) {
        List<Customer> customers = customerRepo.findAllByActiveEquals(state);

        if (!customers.isEmpty()){

            List<CustomerDTO> customerList = customerMapper.customerEntityListToDtoList(customers);

//        List<CustomerDTO> customerDTOS = new ArrayList<>();
//
//        for(Customer customer:customers){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getContactNumbers(),
//                    customer.getCustomerSalary(),
//                    customer.getNic(),
//                    customer.isActive()
//            );
//            customerDTOS.add(customerDTO);
//        }

            return customerList;

        }else{
         throw new NotFoundException("No Customer Found");
        }
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        try{

//        Customer customer = new Customer(
//                customerDTO.getCustomerId(),
//                customerDTO.getCustomerName(),
//                customerDTO.getCustomerAddress(),
//                customerDTO.getContactNumbers(),
//                customerDTO.getCustomerSalary(),
//                customerDTO.getNic(),
//                customerDTO.isActive()
//        );
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        if(!customerRepo.existsById(customer.getCustomerId())){
        customerRepo.save(customer);}
        else throw new DuplicateKeyException("Already existed");
        }
        catch (IllegalArgumentException e){
            throw new RuntimeException("Mapping error",e);
        }
        catch (DataAccessException e){
            throw new RuntimeException("Database error",e);
        }
        catch (Exception e){
            throw new Exception("Unexpected error");
        }
    }

    @Override
    public void updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            try {
                Customer customer = modelMapper.map(customerUpdateDTO, Customer.class);
//            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
//            customer.setCustomerId(customerUpdateDTO.getCustomerId());
//            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
//            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
//            customer.setCustomerName(customerUpdateDTO.getCustomerName());
                customerRepo.save(customer);
            }
            catch (Exception e){
                throw new Exception("Unexpected error");
            }

        } else throw new NotFoundException("Not found user id");
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            try {
                Customer customer = customerRepo.getReferenceById(customerId);

//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getContactNumbers(),
//                    customer.getCustomerSalary(),
//                    customer.getNic(),
//                    customer.isActive()
//            );

                CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
                return customerDTO;
            }
            catch (Exception e){
                throw  new Exception("Unexpected error");
            }
        } else {
            throw new RuntimeException("Not found a customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepo.findAll();
        if(!allCustomers.isEmpty()) {
            List<CustomerDTO> customerDTOList = customerMapper.customerEntityListToDtoList(allCustomers);
//        List<CustomerDTO> customerDTOList = new ArrayList<>();
//        for(Customer customer:allCustomers){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getContactNumbers(),
//                    customer.getCustomerSalary(),
//                    customer.getNic(),
//                    customer.isActive()
//            );
//            customerDTOList.add(customerDTO);
//        }

            return customerDTOList;
        }else throw new NotFoundException("No any saved customer");
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "deleted successfully " + customerId;
        } else throw new RuntimeException("No customer found");
    }
}
