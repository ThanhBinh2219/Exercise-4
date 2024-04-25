package com.javaweb.service.impl;

import com.javaweb.converter.CustomerConverter;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.entity.CustomerEntity;
import com.javaweb.repository.AssignmentCustomerRepository;
import com.javaweb.repository.ICustomerRepository;
import com.javaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private AssignmentCustomerRepository assignmentCustomerRepository;

    @Override
    public List<CustomerDTO> findAll(Pageable page) {
        Pageable pageable = page;
        Page<CustomerEntity> customerEntities = customerRepository.findAll(pageable);
        List<CustomerEntity> customers = customerEntities.getContent();
        return customers.stream().map(c -> customerConverter.converterToDTO(c)).collect(Collectors.toList());
    }

    @Override
    public int countTotalCustomer() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities.size();
    }

    @Override
    public CustomerDTO addAndUpdateCustomer(CustomerDTO customerDTO) {
        Long customerId = customerDTO.getId();
        CustomerEntity customerEntity = customerConverter.converterToEntity(customerDTO);
        return customerConverter.converterToDTO(customerRepository.save(customerEntity));

    }

    @Override
    @Transactional
    public void deleteCustomer(List<Long> ids) {
        for (Long id :ids) {
            assignmentCustomerRepository.deleteAssignmentCustomer(id);
            customerRepository.deleteById(id);
        }
        System.out.println("ok");
    }
}
