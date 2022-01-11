package com.PlantManager.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CalendarDto {
    @NotBlank
    private String title;
    @NotNull
    private LocalDate start;
    @NotNull
    private LocalDate end;
    @NotBlank
    @NotBlank
    private String color;

}
