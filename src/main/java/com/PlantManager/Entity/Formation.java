package com.PlantManager.Entity;

import com.PlantManager.Enums.FormationType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "formation")
@NoArgsConstructor
@Data
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "formation_type")
    @Enumerated(EnumType.STRING)
    private FormationType formationType;

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

    public Formation(FormationType formationType, LocalDate dateFrom, LocalDate dateTo, Plant plant, long userId) {
        this.formationType = formationType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.plant = plant;
        this.userId = userId;
    }
}
