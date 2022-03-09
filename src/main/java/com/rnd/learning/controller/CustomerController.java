package com.rnd.learning.controller;

import com.rnd.learning.domain.BaseResponse;
import com.rnd.learning.domain.Customer;
import com.rnd.learning.domain.CustomerResponseDto;
import com.rnd.learning.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;
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

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteCustomerId(@RequestBody DeleteCustomerRq request) {
        customerService.deleteCustomer(request.getCustomerId());
        return ResponseEntity.ok(BaseResponse.builder()
                        .message("Success delete data")
                .build());
    }

    @PostMapping("/findByOccupation")
    public ResponseEntity<Object> findOccupation(@RequestBody FindOccupationRq request) {
        String message = "";
        var customer = customerService.getCustomerByOccupation(request.getOccupation());
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

    @GetMapping("/get/findByAddress")
    public ResponseEntity<Object> findAddress(@RequestParam String address) {
        String message = "";
        var customer = customerService.getCustomerByAdress(String.valueOf(address));
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

    //@PostMapping("/post/updateAddress")
    //public ResponseEntity<Object> updateAddress(@RequestParam Long id, @RequestParam UpdateAddressRq newAddress) {
    //    String message = "";
    //    var customer = customerService.getCustomerById(id);
    //    Address = newAddress;
    //}

    @PutMapping("/updateCustomer")
    public void updateCustomer(
            @PathVariable Long id,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String occupation){
        customerService.updateCustomer(id, address, occupation);
    }



}

@Data
@AllArgsConstructor
@NoArgsConstructor
class FindOccupationRq {
    private String occupation;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class DeleteCustomerRq {
    private Long customerId;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class UpdateAddressRq {
    private String newAddress;
}