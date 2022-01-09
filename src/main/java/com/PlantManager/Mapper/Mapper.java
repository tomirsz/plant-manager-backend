package com.PlantManager.Mapper;

import com.PlantManager.Dao.*;
import com.PlantManager.Dto.NewPlantDto;
import com.PlantManager.Entity.*;
import com.PlantManager.Enums.Insolation;
import com.PlantManager.Enums.Irrigation;
import com.PlantManager.Enums.PlantType;
import com.PlantManager.Enums.SoilType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Mapper {

    public Plant mapNewPlantDtoToPlant(NewPlantDto dto) {
        return new Plant(
                dto.getName(),
                dto.getLatinName(),
                Insolation.valueOf(dto.getInsolation()),
                Irrigation.valueOf(dto.getIrrigation()),
                PlantType.valueOf(dto.getPlantType()),
                SoilType.valueOf(dto.getSoilType()));
    }


    public List<FertilizationDao> mapToFertilizationDao(List<Fertilization> entity) {
        return entity.stream()
                .map(e -> new FertilizationDao(
                        e.getId(),
                        e.getName(),
                        e.getDateFrom(),
                        e.getDateTo()
                )).collect(Collectors.toList());
    }

    public List<PruneDao> mapToPruneDao(List<Prune> entity) {
        return entity.stream()
                .map(e -> new PruneDao(
                        e.getId(),
                        e.getNote(),
                        e.getDateFrom(),
                        e.getDateTo()
                )).collect(Collectors.toList());
    }

    public List<SprayingDao> mapToSprayingDao(List<Spraying> entity) {
        return entity.stream()
                .map(e -> new SprayingDao(
                        e.getId(),
                        e.getName(),
                        e.getDateFrom(),
                        e.getDateTo()
                )).collect(Collectors.toList());
    }

    public List<FormationDao> mapToFormationDao(List<Formation> entity) {
        return entity.stream()
                .map(e -> new FormationDao(
                        e.getId(),
                        e.getFormationType().name(),
                        e.getDateFrom(),
                        e.getDateTo()
                )).collect(Collectors.toList());
    }

    public List<RepottingDao> mapToRepottingDao(List<Repotting> entity) {
        return entity.stream()
                .map(e -> new RepottingDao(
                        e.getId(),
                        e.getNote(),
                        e.getDate()
                )).collect(Collectors.toList());
    }

    public List<IrrigationDateDao> mapToIrrigationDateDao(List<IrrigationDate> entity) {
        return entity.stream()
                .map(e -> new IrrigationDateDao(
                        e.getId(),
                        e.getNote(),
                        e.getDate()
                )).collect(Collectors.toList());
    }
}
