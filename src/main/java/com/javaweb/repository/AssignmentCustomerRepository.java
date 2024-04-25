package com.javaweb.repository;

import com.javaweb.model.entity.AssignmentCustomerEntity;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface AssignmentCustomerRepository extends JpaRepository<AssignmentCustomerEntity, Long> {
    @Modifying
    @Query(value = "DELETE FROM AssignmentCustomerEntity ac WHERE ac.customers.id = :id")
    public void deleteAssignmentCustomer(@PathVariable("id") Long id);
}
