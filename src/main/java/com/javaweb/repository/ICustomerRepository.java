package com.javaweb.repository;

import com.javaweb.model.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long>{
    Page<CustomerEntity> findAll(Pageable pageable);

    void deleteByIdIn(List<Long> ids);
}
