package com.javaweb.service.impl;

import com.javaweb.converter.CustomerConverter;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.StaffDTO;
import com.javaweb.model.entity.AssignmentCustomerEntity;
import com.javaweb.model.entity.CustomerEntity;
import com.javaweb.model.entity.UserEntity;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentCustomerRepository;
import com.javaweb.repository.ICustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
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
    public CustomerDTO findById(Long id) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity = customerRepository.findById(id).get();
        CustomerDTO customerDTO = customerConverter.converterToDTO(customerEntity);
        return customerDTO;
    }

    @Override
    public int countTotalCustomer() {
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        return customerEntities.size();
    }

    @Override
    @Transactional
    public CustomerDTO addAndUpdateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerConverter.converterToEntity(customerDTO);
        return customerConverter.converterToDTO(customerRepository.save(customerEntity));

    }

    @Override
    @Transactional
    public void deleteCustomer(List<Long> ids) {
        for (Long id : ids) {
            assignmentCustomerRepository.deleteAssignmentCustomer(id);
            customerRepository.deleteById(id);
        }
    }

//    @Override
//    public StaffResponseDTO getStaffsByCustomerId(Long customerId) {
//        CustomerEntity customerEntity = customerRepository.findById(customerId).get();
//        List<AssignmentCustomerEntity> assignmentCustomerEntities = customerEntity.getAssignmentCustomerEntities();
//        List<UserEntity> staff = userRepository.findByStatusAndRoles_Code(1, "STAFF");
//        List<UserEntity> staffAssignmentCustomer = assignmentCustomerEntities.stream()
//                .map(AssignmentCustomerEntity::getUsers)
//                .collect(Collectors.toList());
//        StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
//        for (UserEntity user : staff) {
//            StaffDTO staffDTO = new StaffDTO();
//            staffDTO.setStaffId(user.getId());
//            staffDTO.setFullName(user.getFullName());
//            if (staffAssignmentCustomer.contains(user.getId())) {
//                staffDTO.setChecked("checked");
//            } else {
//                staffDTO.setChecked("");
//            }
//            staffResponseDTO.setData(staffDTO);
//        }
//        return staffResponseDTO;
//    }

}
