package com.PlantManager.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationDao {
    private Long id;
    private String formationType;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
