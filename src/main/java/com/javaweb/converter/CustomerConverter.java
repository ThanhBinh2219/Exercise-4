package com.javaweb.converter;

import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    @Autowired
    private ModelMapper modelMapper;

    /*Chuyển đổi CostomerEntity sang CustomerDTO*/
    public CustomerDTO converterToDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);
        return customerDTO;
    }

    /*Chuyển đổi CostomerDTO sang CustomerEntity*/
    public CustomerEntity converterToEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
        return customerEntity;
    }
}
