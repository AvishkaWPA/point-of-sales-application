package com.example.point_of_sale.controller;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.dto.request.CustomerUpdateDTO;
import com.example.point_of_sale.entity.Customer;
import com.example.point_of_sale.service.CustomerService;
import com.example.point_of_sale.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")  //localhost:8090/api/v1/customer
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PostMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        customerService.updateCustomer(customerUpdateDTO);
        return "updated";
    }

    @GetMapping(path = "/get-by-id", params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping("/get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(value = "/get-all-by-active-state/{state}")
    public List<CustomerDTO> getAllCustomerByActiveState(@PathVariable(value = "state") boolean state){
        List<CustomerDTO> allCustomersByActiveState = customerService.getAllCustomerByActiveState(state);
        return allCustomersByActiveState;
    }


}
