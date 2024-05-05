package com.javaweb.api.admin;

import com.javaweb.model.dto.Customer;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.StaffDTO;
import com.javaweb.model.request.AssignmentRequest;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.service.IAssignmentCustomerService;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
public class CustomerAPI {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IAssignmentCustomerService assignmentCustomerService;


    @PostMapping
    public ResponseEntity<CustomerDTO> createAndUpdateCustomer(@RequestBody CustomerDTO customerDTO) {
        ResponseEntity<CustomerDTO> response = ResponseEntity.ok(customerService.addAndUpdateCustomer(customerDTO));

        return response;
    }

    @DeleteMapping("/delete-customer/{ids}")
    public ResponseEntity<String> deleteCustomers(@PathVariable("ids") String ids) {
        List<Long> customerIds = Arrays.stream(ids.split("-"))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        customerService.deleteCustomer(customerIds);
        return ResponseEntity.ok("Delete customer success");
    }

    @GetMapping("/{customerId}/staffs")
    public StaffResponseDTO loadStaff(@PathVariable("customerId") Long customerId) {
        StaffResponseDTO staff = new StaffResponseDTO();
        List<StaffDTO> manage = assignmentCustomerService.getStaffsByCustomerId(customerId);
        staff.setData(manage);
        return staff;
    }
    @PutMapping("/staff")
    public void updateAssignmentBuilding(@RequestBody AssignmentRequest assignmentRequest) {
        for (Long staffId :
                assignmentRequest.getStaffsChecked()) {
            assignmentCustomerService.updateAssignment(staffId, assignmentRequest.getCustomerId());
        }
    }

    @GetMapping("/hello-world")
    public String test() {
        return "Hello World";
    }
}
