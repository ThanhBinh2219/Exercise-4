package com.javaweb.api.admin;

import com.javaweb.model.dto.Customer;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.service.ICustomerService;
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


    @GetMapping("/hello-world")
    public String test() {
        return "Hello World";
    }
}
