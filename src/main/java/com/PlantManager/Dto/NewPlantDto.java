package com.PlantManager.Dto;

import com.PlantManager.Enums.Insolation;
import com.PlantManager.Enums.Irrigation;
import com.PlantManager.Enums.PlantType;
import lombok.Data;

@Data
public class NewPlantDto {

    private String name;
    private String latinName;
    private String insolation;
    private String irrigation;
    private String plantType;
    private String soilType;
}
