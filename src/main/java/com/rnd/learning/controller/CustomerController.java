package com.rnd.learning.controller;

import com.rnd.learning.domain.BaseResponse;
import com.rnd.learning.domain.Customer;
import com.rnd.learning.domain.CustomerResponseDto;
import com.rnd.learning.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Stevanus Prasetyo Dwicahyono
 * stevanus.dwicahyono@ist.id
 * 25/02/22
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/all")
    public ResponseEntity<Object> getAllCustomer() {
        var customer = customerService.findAllCustomer();
        var response = CustomerResponseDto.builder()
                .message("success")
                .data(customer)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/findById")
    public ResponseEntity<Object> getCustomerById(@RequestParam Long id) {
        String message = "";
        var customer = customerService.getCustomerById(id);
        if (customer == null)
            message = "Customer Not Found";
        else
            message = "success";
        var response = CustomerResponseDto.builder()
                .message(message)
                .data(Stream.of(customer).collect(Collectors.toList()))
                .build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.ok(BaseResponse.builder()
                        .message("Success insert data")
                .build());
    }

    public ResponseEntity<Object> findOccupation(@RequestParam String occupation) {
        // code here
        // test commit
        // pandji commit
        return null;
    }

}
