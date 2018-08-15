package com.llxh.basic.base.utils;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
public class User {
    private String userName;
    private String userId;
    private Integer userAge;
}
