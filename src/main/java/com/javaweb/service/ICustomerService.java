package com.javaweb.service;

import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll(Pageable pageable);

    int countTotalCustomer();
    CustomerDTO addAndUpdateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(List<Long> ids);
}
