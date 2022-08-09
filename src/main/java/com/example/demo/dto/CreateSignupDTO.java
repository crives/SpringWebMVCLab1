package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CreateSignupDTO {
    @Min(value = 0)
    @Max(23)
    private int time;
    private Long activity_id;
    private Long camper_id;
}
