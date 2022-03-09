package com.rnd.learning.repository;

import com.rnd.learning.domain.Customer;
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
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerNameIs(String customerName);

    @Query("select t from t_customer t where t.customerOccupation = ?1")
    Customer findByCustomerOccupation(String customerOccupation);

    @Query("select t from t_customer t where t.customerAddress = ?1")
    Customer findByCustomerAddress(String customerAddress);

}
