package com.PlantManager.Service;

import com.PlantManager.Dao.*;
import com.PlantManager.Dto.CalendarDto;
import com.PlantManager.Dto.NewPlantDto;
import com.PlantManager.Dto.PlantHistory;
import com.PlantManager.Entity.*;
import com.PlantManager.Mapper.Mapper;
import com.PlantManager.Repository.*;
import com.PlantManager.Repository.IrrigationDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlantService {

    public static final String COLOR1 = "#512da8";
    public static final String COLOR2 = "#d32f2f";
    public static final String COLOR3 = "#388e3c";
    public static final String COLOR4 = "#e64a19";
    public static final String COLOR5 = "#5d4037";
    public static final String COLOR6 = "#1976d2";

    public static final String FERTILIZATION_TITLE = "Nawożenie";
    public static final String SPRAYING_TITLE = "Oprysk";
    public static final String PRUNE_TITLE = "Przycinanie";
    public static final String FORMATION_TITLE = "Formowanie";
    public static final String REPOTTING_TITLE = "Przesadzanie";
    public static final String IRRIGATION_TITLE = "Podlewanie";
    @Autowired
    private Mapper mapper;

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private FertilizationRepository fertilizationRepository;

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private PruneRepository pruneRepository;

    @Autowired
    private SprayingRepository sprayingRepository;

    @Autowired
    private RepottingRepository repottingRepository;

    @Autowired
    private IrrigationDateRepository irrigationDateRepository;

    @Autowired
    private UserRepository userRepository;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public Plant addPlant(NewPlantDto dto) {
        Plant plant = mapper.mapNewPlantDtoToPlant(dto);
        plant.setUserId(getCurrentUser());
        return plantRepository.save(plant);
    }

    public List<Plant> findAll() {
        return plantRepository.findAll(getCurrentUser());
    }

    public Plant findById(Long id) {
        return plantRepository.getOne(id);
    }

    public List<CalendarDto> getCalendar(String dateFrom, String dateTo) {
        List<FertilizationDao> fertilizationDaos = mapper.mapToFertilizationDao(fertilizationRepository.getFertilizationForCalendar(parseDate(dateFrom), parseDate(dateTo), getCurrentUser()));
        List<PruneDao> pruneDaos = mapper.mapToPruneDao(pruneRepository.getPruneForCalendar(parseDate(dateFrom), parseDate(dateTo), getCurrentUser()));
        List<SprayingDao> sprayingDaos = mapper.mapToSprayingDao(sprayingRepository.getSprayingForCalendar(parseDate(dateFrom), parseDate(dateTo), getCurrentUser()));
        List<FormationDao> formationDaos = mapper.mapToFormationDao(formationRepository.getFormationForCalendar(parseDate(dateFrom), parseDate(dateTo), getCurrentUser()));
        List<RepottingDao> repottingDaos = mapper.mapToRepottingDao(repottingRepository.getRepottingForCalendar(parseDate(dateFrom), parseDate(dateTo), getCurrentUser()));
        List<IrrigationDateDao> irrigationDateDaos = mapper.mapToIrrigationDateDao(irrigationDateRepository.getIrrigationDateForCalendar(parseDate(dateFrom), parseDate(dateTo), getCurrentUser()));
        List<CalendarDto> resultList = new ArrayList<>();
        fertilizationDaos
                .forEach(f -> resultList.add(new CalendarDto(FERTILIZATION_TITLE + ": " + f.getName(), f.getDateFrom(), f.getDateTo(), COLOR1)));
        pruneDaos
                .forEach(f -> resultList.add(new CalendarDto(PRUNE_TITLE + ": " + f.getNote(), f.getDateFrom(), f.getDateTo(), COLOR2)));
        sprayingDaos
                .forEach(f -> resultList.add(new CalendarDto(SPRAYING_TITLE + ": " + f.getName(), f.getDateFrom(), f.getDateTo(), COLOR3)));
        formationDaos
                .forEach(f -> resultList.add(new CalendarDto(FORMATION_TITLE + ": " + f.getFormationType(), f.getDateFrom(), f.getDateTo(), COLOR4)));
        repottingDaos
                .forEach(f -> resultList.add(new CalendarDto(REPOTTING_TITLE + ": " + f.getNote(), f.getDate(), f.getDate(), COLOR5)));
        irrigationDateDaos
                .forEach(f -> resultList.add(new CalendarDto(IRRIGATION_TITLE + ": " + f.getNote(), f.getDate(), f.getDate(), COLOR6)));

        return resultList;
    }

    public List<CalendarDto> getCalendar(String dateFrom, String dateTo, String plantId) {
        List<FertilizationDao> fertilizationDaos = mapper.mapToFertilizationDao(fertilizationRepository.getFertilizationForCalendar(parseDate(dateFrom), parseDate(dateTo), Integer.parseInt(plantId)));
        List<PruneDao> pruneDaos = mapper.mapToPruneDao(pruneRepository.getPruneForCalendar(parseDate(dateFrom), parseDate(dateTo), Integer.parseInt(plantId)));
        List<SprayingDao> sprayingDaos = mapper.mapToSprayingDao(sprayingRepository.getSprayingForCalendar(parseDate(dateFrom), parseDate(dateTo), Integer.parseInt(plantId)));
        List<FormationDao> formationDaos = mapper.mapToFormationDao(formationRepository.getFormationForCalendar(parseDate(dateFrom), parseDate(dateTo), Integer.parseInt(plantId)));
        List<RepottingDao> repottingDaos = mapper.mapToRepottingDao(repottingRepository.getRepottingForCalendar(parseDate(dateFrom), parseDate(dateTo), Integer.parseInt(plantId)));
        List<IrrigationDateDao> irrigationDateDaos = mapper.mapToIrrigationDateDao(irrigationDateRepository.getIrrigationDateForCalendar(parseDate(dateFrom), parseDate(dateTo), Integer.parseInt(plantId)));

        List<CalendarDto> resultList = new ArrayList<>();
        fertilizationDaos
                .forEach(f -> resultList.add(new CalendarDto(FERTILIZATION_TITLE + ": " + f.getName(), f.getDateFrom(), f.getDateTo(), COLOR1)));
        pruneDaos
                .forEach(f -> resultList.add(new CalendarDto(PRUNE_TITLE + ": " + f.getNote(), f.getDateFrom(), f.getDateTo(), COLOR2)));
        sprayingDaos
                .forEach(f -> resultList.add(new CalendarDto(SPRAYING_TITLE + ": " + f.getName(), f.getDateFrom(), f.getDateTo(), COLOR3)));
        formationDaos
                .forEach(f -> resultList.add(new CalendarDto(FORMATION_TITLE + ": " + f.getFormationType(), f.getDateFrom(), f.getDateTo(), COLOR4)));
        repottingDaos
                .forEach(f -> resultList.add(new CalendarDto(REPOTTING_TITLE + ": " + f.getNote(), f.getDate(), f.getDate(), COLOR5)));
        irrigationDateDaos
                .forEach(f -> resultList.add(new CalendarDto(IRRIGATION_TITLE + ": " + f.getNote(), f.getDate(), f.getDate(), COLOR6)));

        return resultList;
    }

    private LocalDate parseDate(String dateFrom) {
        return LocalDate.parse(dateFrom, dateTimeFormatter);
    }

    public List<PlantHistory> fetchPlantHistory() {
        return plantRepository.findAll(getCurrentUser()).stream()
                .map(p -> new PlantHistory(p.getId().toString(), p.getName())).collect(Collectors.toList());
    }

    public Spraying addSpraying(Long id, Spraying spraying) {
        spraying.setUserId(getCurrentUser());
        Plant plant = findById(id);
        spraying.setPlant(plant);
        sprayingRepository.save(new Spraying(
                spraying.getName(),
                spraying.getAmount(),
                spraying.getDateFrom(),
                spraying.getDateTo(),
                spraying.getPlant(),
                spraying.getUserId()
        ));
        return spraying;
    }

    public Fertilization addFertilization(Long id, Fertilization fertilization) {
        fertilization.setUserId(getCurrentUser());
        Plant plant = findById(id);
        fertilization.setPlant(plant);
        fertilizationRepository.save(new Fertilization(
                fertilization.getName(),
                fertilization.getAmount(),
                fertilization.getDateFrom(),
                fertilization.getDateTo(),
                fertilization.getPlant(),
                fertilization.getUserId()
        ));
        return fertilization;
    }

    public Formation addFormation(Long id, Formation formation) {
        formation.setUserId(getCurrentUser());
        Plant plant = findById(id);
        formation.setPlant(plant);
        formationRepository.save(new Formation(
                formation.getFormationType(),
                formation.getDateFrom(),
                formation.getDateTo(),
                formation.getPlant(),
                formation.getUserId()
        ));
        return formation;
    }

    public Prune addPrune(Long id, Prune prune) {
        prune.setUserId(getCurrentUser());
        Plant plant = findById(id);
        prune.setPlant(plant);
        pruneRepository.save(new Prune(
                prune.getNote(),
                prune.getDateFrom(),
                prune.getDateTo(),
                prune.getPlant(),
                prune.getUserId()
        ));
        return prune;
    }

    public IrrigationDate addIrrigationDate(Long id, IrrigationDate irrigationDate) {
        irrigationDate.setUserId(getCurrentUser());
        Plant plant = findById(id);
        irrigationDate.setPlant(plant);
        irrigationDateRepository.save(new IrrigationDate(
                irrigationDate.getNote(),
                irrigationDate.getDate(),
                irrigationDate.getPlant(),
                irrigationDate.getUserId()
        ));
        return irrigationDate;
    }

    public Repotting addRepotting(Long id, Repotting repotting) {
        repotting.setUserId(getCurrentUser());
        Plant plant = findById(id);
        repotting.setPlant(plant);
        repottingRepository.save(new Repotting(
                repotting.getNote(),
                repotting.getDate(),
                repotting.getPlant(),
                repotting.getUserId()
        ));
        return repotting;
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }

    public Plant editPlant(Plant newPlant) {
        Plant plant = plantRepository.findById(newPlant.getId()).orElse(new Plant());
        plant.setName(newPlant.getName());
        plant.setLatinName(newPlant.getLatinName());
        plant.setInsolation(newPlant.getInsolation());
        plant.setIrrigation(newPlant.getIrrigation());
        plant.setPlantType(newPlant.getPlantType());
        plant.setSoilType(newPlant.getSoilType());
        plant.setUserId(getCurrentUser());
        return plantRepository.save(plant);
    }

    private Long getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        return user.map(User::getId).orElse(null);
    }
}
