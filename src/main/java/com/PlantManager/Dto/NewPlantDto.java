package com.PlantManager.Dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class NewPlantDto {
    @NotBlank
    private String name;
    @NotBlank
    private String latinName;
    @NotBlank
    private String insolation;
    @NotBlank
    private String irrigation;
    @NotBlank
    private String plantType;
    @NotBlank
    private String soilType;
}
