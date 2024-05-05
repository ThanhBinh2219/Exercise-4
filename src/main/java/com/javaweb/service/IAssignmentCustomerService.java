package com.javaweb.service;

import com.javaweb.model.dto.StaffDTO;

import java.util.List;

public interface IAssignmentCustomerService {
    List<StaffDTO> getStaffsByCustomerId(Long customerId);
    void updateAssignment(Long staffid, Long customerId);
}
