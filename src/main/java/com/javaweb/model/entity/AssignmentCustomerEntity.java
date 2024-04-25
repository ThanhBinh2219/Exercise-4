package com.javaweb.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "assignmentcustomer")
public class AssignmentCustomerEntity extends BaseEntity{
   @ManyToOne
    @JoinColumn(name = "staffid")
    private UserEntity users;
   @ManyToOne
    @JoinColumn(name = "customerid")
    private CustomerEntity customers;
}
