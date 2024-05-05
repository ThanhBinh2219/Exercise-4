package com.javaweb.service.impl;

import com.javaweb.SpringBootWebApplication;
import com.javaweb.model.dto.StaffDTO;
import com.javaweb.model.entity.AssignmentCustomerEntity;
import com.javaweb.model.entity.CustomerEntity;
import com.javaweb.model.entity.UserEntity;
import com.javaweb.repository.AssignmentCustomerRepository;
import com.javaweb.repository.ICustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IAssignmentCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmnentCustomerServiceImpl implements IAssignmentCustomerService {

    @Autowired
    private AssignmentCustomerRepository assignmentCustomerRepository;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<StaffDTO> getStaffsByCustomerId(Long customerId) {
        List<AssignmentCustomerEntity> assignments = assignmentCustomerRepository.findByCustomerId(customerId);
        List<UserEntity> users = assignments.stream()
                .map(assignment -> assignment.getUsers())
                .collect(Collectors.toList());
        List<StaffDTO> staff = new ArrayList<>();
        for (UserEntity user:
                users) {
            StaffDTO s = new StaffDTO();
            s.setStaffId(user.getId());
            s.setFullName(user.getFullName());
            s.setChecked("checked");
            staff.add(s);
        }
        return staff;

    }

    @Override
    @Transactional
    public void updateAssignment(Long staffid, Long customerId) {
        assignmentCustomerRepository.deleteAssignmentCustomer(customerId);
        AssignmentCustomerEntity assignmentCustomerEntity = new AssignmentCustomerEntity();
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();
        UserEntity userEntity = userRepository.findById(staffid).get();
        assignmentCustomerEntity.setCustomers(customerEntity);
        assignmentCustomerEntity.setUsers(userEntity);
        assignmentCustomerRepository.save(assignmentCustomerEntity);
    }
}
