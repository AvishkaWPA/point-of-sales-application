package com.example.point_of_sale.controller;

import com.example.point_of_sale.dto.CustomerDTO;
import com.example.point_of_sale.dto.request.CustomerUpdateDTO;
import com.example.point_of_sale.service.CustomerService;
import com.example.point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")  //localhost:8090/api/v1/customer
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(201,"Success",null), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        customerService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",customerDTO),HttpStatus.OK);
    }

    @GetMapping("/get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",allCustomers),HttpStatus.OK);
    }

    @DeleteMapping(path = "delete-customer/{id}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",deleted),HttpStatus.OK);
    }

    @GetMapping(value = "/get-all-by-active-state/{state}")
    public ResponseEntity<StandardResponse> getAllCustomerByActiveState(@PathVariable(value = "state") boolean state){
        List<CustomerDTO> allCustomersByActiveState = customerService.getAllCustomerByActiveState(state);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",allCustomersByActiveState),HttpStatus.OK);
    }


}
