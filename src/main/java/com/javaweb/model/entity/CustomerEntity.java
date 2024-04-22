package com.javaweb.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity extends BaseEntity{

    @Column(name = "fullname")
    private String name;
    @Column(name = "phone")
    private String customerPhone;
    private String email;
    @Column(name = "companyname")
    private String companyName;
    private String demand;
    private String status;
}
