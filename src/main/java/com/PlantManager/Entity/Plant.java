package com.PlantManager.Entity;

import com.PlantManager.Enums.Insolation;
import com.PlantManager.Enums.Irrigation;
import com.PlantManager.Enums.PlantType;
import com.PlantManager.Enums.SoilType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "plant")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "latin_name")
    private String latinName;

    @Column(name = "insolation")
    private Insolation insolation;

    @Column(name = "irrigation")
    private Irrigation irrigation;

    @Column(name = "plant_type")
    private PlantType plantType;

    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL)
    @Column(name = "spraying")
    private List<Spraying> spraying = new ArrayList<>();

    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL)
    @Column(name = "fertilization")
    private List<Fertilization> fertilization = new ArrayList<>();

    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL)
    @Column(name = "formation")
    private List<Formation> formation = new ArrayList<>();

    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL)
    @Column(name = "prune")
    private List<Prune> prune = new ArrayList<>();

    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL)
    @Column(name = "repotting")
    private List<Repotting> repottings = new ArrayList<>();

    @Column(name = "soil_type")
    private SoilType soilType;

    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL)
    @Column (name = "irrigation_date")
    private List<IrrigationDate> irrigationDate = new ArrayList<>();

    @JsonIgnore
    @Column (name = "user_id")
    private long userId;

    public Plant(String name, String latinName,
                 Insolation insolation, Irrigation irrigation,
                 PlantType plantType, SoilType soilType) {
        this.name = name;
        this.latinName = latinName;
        this.insolation = insolation;
        this.irrigation = irrigation;
        this.plantType = plantType;
        this.soilType = soilType;
    }
}
