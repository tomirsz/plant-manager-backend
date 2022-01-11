package com.PlantManager.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class PlantHistory {

    @NotBlank
    private String id;
    @NotBlank
    private String name;
}
