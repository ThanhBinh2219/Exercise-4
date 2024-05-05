package com.javaweb.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StaffDTO {
    private Long staffId;
    private String fullName;
    private String checked;
}