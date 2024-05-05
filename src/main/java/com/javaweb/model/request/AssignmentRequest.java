package com.javaweb.model.request;

import lombok.Data;

import java.util.List;
@Data
public class AssignmentRequest {
    private Long customerId;
    private List<Long> staffsChecked;
}
