package com.rnd.learning.repository;

import com.rnd.learning.domain.Customer;
import com.rnd.learning.domain.CustomerAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Stevanus Prasetyo Dwicahyono
 * stevanus.dwicahyono@ist.id
 * 25/02/22
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerAttributes, Long> {

    @Query(nativeQuery = true)
    CustomerAttributes findByCustomerAttributesName(String name);
    Customer findByCustomerNameIs(String customerName);

    @Query(value = "select t from t_customer t where t.customerOccupation = ?1", nativeQuery = true)
    CustomerAttributes findByCustomerAttributesOccupation(String occupation);
    Customer findByCustomerOccupation(String customerOccupation);

    @Query(value = "select t from t_customer t where t.customerAddress = ?1", nativeQuery = true)
    CustomerAttributes findByCustomerAttributesAddress(String address);
    Customer findByCustomerAddress(String customerAddress);

}
