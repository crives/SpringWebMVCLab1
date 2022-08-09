package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CamperDTO {
    private Long id;
    private String name;
    @Min(value = 8)
    @Max(value = 18)
    private int age;
}
