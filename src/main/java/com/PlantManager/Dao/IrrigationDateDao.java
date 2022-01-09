package com.PlantManager.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationDateDao {
    private Long id;
    private String note;
    private LocalDate date;
}
