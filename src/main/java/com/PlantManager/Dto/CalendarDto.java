package com.PlantManager.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CalendarDto {
    private String title;
    private LocalDate start;
    private LocalDate end;
    private String color;

}
