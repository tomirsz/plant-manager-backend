package com.PlantManager.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "prune")
@NoArgsConstructor
@Data
public class Prune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "note")
    private String note;

    @Column (name = "date_from")
    private LocalDate dateFrom;

    @Column (name = "date_to")
    private LocalDate dateTo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Plant plant;

    @JsonIgnore
    @Column (name = "user_id")
    private long userId;

    public Prune(String note, LocalDate dateFrom, LocalDate dateTo, Plant plant, long userId) {
        this.note = note;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.plant = plant;
        this.userId = userId;
    }
}
