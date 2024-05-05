package com.javaweb.repository;

import com.javaweb.model.entity.AssignmentCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public interface AssignmentCustomerRepository extends JpaRepository<AssignmentCustomerEntity, Long> {
    @Modifying
    @Query(value = "DELETE FROM AssignmentCustomerEntity ac WHERE ac.customers.id = :id")
    void deleteAssignmentCustomer(@PathVariable("id") Long id);
    @Modifying
    @Query( value = "SELECT a FROM AssignmentCustomerEntity a WHERE a.customers.id = :customerId")
    List<AssignmentCustomerEntity> findByCustomerId(@Param("customerId") Long customerId);


}
