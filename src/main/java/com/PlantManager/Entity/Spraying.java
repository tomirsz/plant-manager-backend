package com.PlantManager.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "spraying")
@NoArgsConstructor
@Data
public class Spraying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "amount")
    private BigDecimal amount;

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

    public Spraying(String name, BigDecimal amount, LocalDate dateFrom, LocalDate dateTo, Plant plant, long userId) {
        this.name = name;
        this.amount = amount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.plant = plant;
        this.userId = userId;
    }
}
