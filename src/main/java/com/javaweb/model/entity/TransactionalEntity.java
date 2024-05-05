package com.javaweb.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionalEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String note;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private CustomerEntity customers;
}
