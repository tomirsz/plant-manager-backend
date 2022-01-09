package com.PlantManager.Controller;

import com.PlantManager.Dto.CalendarDto;
import com.PlantManager.Dto.NewPlantDto;
import com.PlantManager.Dto.PlantHistory;
import com.PlantManager.Entity.*;
import com.PlantManager.Service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public Plant addPlant(@RequestBody NewPlantDto plantDto) {
        return plantService.addPlant(plantDto);
    }

    @PutMapping(value = "/edit", consumes = APPLICATION_JSON_VALUE)
    public Plant editPlant(@RequestBody Plant plant) { return plantService.editPlant(plant); }

    @DeleteMapping(value = "/delete")
    public void deletePlant(@RequestParam Long id) { plantService.deletePlant(id); }

    @GetMapping(value = "/find")
    public List<Plant> getAll() {
        return plantService.findAll();
    }

    @GetMapping(value = "/fetchCalendar/fetchPlants")
    public List<PlantHistory>getPlantHistory() {
        return plantService.fetchPlantHistory();
    }

    @GetMapping(value = "/fetchCalendar")
    public List<CalendarDto> getCalendar(@RequestParam String dateFrom, @RequestParam String dateTo) {
        return plantService.getCalendar(dateFrom, dateTo);
    }

    @GetMapping(value = "/fetchCalendarForHistory")
    public List<CalendarDto> getCalendar(@RequestParam String dateFrom, @RequestParam String dateTo, @RequestParam("plantId") String plantId) {
        return plantService.getCalendar(dateFrom, dateTo, plantId);
    }

    @PostMapping(value = "/add/spraying", consumes = APPLICATION_JSON_VALUE)
    public Spraying addSpraying(@RequestParam("id") Long id, @RequestBody Spraying spraying) {
        return plantService.addSpraying(id, spraying);
    }

    @PostMapping(value = "/add/fertilization", consumes = APPLICATION_JSON_VALUE)
    public Fertilization addFertilization(@RequestParam("id") Long id, @RequestBody Fertilization fertilization) {
        return plantService.addFertilization(id, fertilization);
    }

    @PostMapping(value = "/add/formation", consumes = APPLICATION_JSON_VALUE)
    public Formation addFormation(@RequestParam("id") Long id, @RequestBody Formation formation) {
        return plantService.addFormation(id, formation);
    }

    @PostMapping(value = "/add/prune", consumes = APPLICATION_JSON_VALUE)
    public Prune addPrune(@RequestParam("id") Long id, @RequestBody Prune prune) {
        return plantService.addPrune(id, prune);
    }

    @PostMapping(value = "/add/irrigation-date", consumes = APPLICATION_JSON_VALUE)
    public IrrigationDate addIrigationDate(@RequestParam("id") Long id, @RequestBody IrrigationDate irrigationDate) {
        return plantService.addIrrigationDate(id, irrigationDate);
    }

    @PostMapping(value = "/add/repotting", consumes = APPLICATION_JSON_VALUE)
    public Repotting addRepotting(@RequestParam("id") Long id, @RequestBody Repotting repotting) {
        return plantService.addRepotting(id, repotting);
    }
}
