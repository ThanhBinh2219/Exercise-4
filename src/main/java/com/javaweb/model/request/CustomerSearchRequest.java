package com.javaweb.model.request;

import com.javaweb.model.dto.AbstractDTO;
import lombok.Data;

@Data
public class CustomerSearchRequest extends AbstractDTO {
    private String fullName;
    private String customerPhone;
    private String email;
    private Integer staffId;
}
