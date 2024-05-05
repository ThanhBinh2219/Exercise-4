package com.javaweb.service;

import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.StaffDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.entity.CustomerEntity;
import com.javaweb.model.response.StaffResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.ObjectView;
import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<CustomerDTO> findAll(Pageable pageable);

    CustomerDTO findById(Long id);

    int countTotalCustomer();

    CustomerDTO addAndUpdateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(List<Long> ids);

//    StaffResponseDTO getStaffsByCustomerId(Long customerId);
}
