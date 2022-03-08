package com.rnd.learning.service;

import com.rnd.learning.domain.Customer;
import com.rnd.learning.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stevanus Prasetyo Dwicahyono
 * stevanus.dwicahyono@ist.id
 * 25/02/22
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @PostConstruct
    public void initCustomerData() {
        var customer1 = Customer.builder()
                .customerName("John")
                .customerAddress("US")
                .customerOccupation("BackEnd")
                .build();
        var customer2 = Customer.builder()
                .customerName("Peter")
                .customerAddress("Canada")
                .customerOccupation("FrontEnd")
                .build();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerRepository.saveAll(customerList);
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer getCustomerByName(String name) {
        return customerRepository.findByCustomerNameIs(name);
    }

    public Customer getCustomerByOccupation(String occupation) {
        return customerRepository.findByCustomerOccupation(occupation);
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerByAdress(String address) {
        return customerRepository.findByCustomerAddress(address);
    }

    public Customer deleteAllCustomer(Customer customer) {
        return customerRepository.deleteCustomer();
    }

}
