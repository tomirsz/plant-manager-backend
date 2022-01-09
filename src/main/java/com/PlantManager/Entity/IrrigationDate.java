package com.PlantManager.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "irrigation_date")
@NoArgsConstructor
@Data
public class IrrigationDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "note")
    private String note;

    @Column (name = "date")
    private LocalDate date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Plant plant;

    @JsonIgnore
    @Column (name = "user_id")
    private long userId;

    public IrrigationDate(String note, LocalDate date, Plant plant, long userId) {
        this.note = note;
        this.date = date;
        this.plant = plant;
        this.userId = userId;
    }
}
