package com.PlantManager.Repository;

import com.PlantManager.Entity.Fertilization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface FertilizationRepository extends JpaRepository<Fertilization, Long> {
    @Query(value = "SELECT * FROM fertilization where date_from >= :dateFrom or date_to <= :dateTo and user_id = :userId",
            nativeQuery = true)
    List<Fertilization> getFertilizationForCalendar(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("userId") long userId);

    @Query(value = "SELECT * FROM fertilization where date_from >= :dateFrom or date_to <= :dateTo and plant_id = :plantId",
            nativeQuery = true)
    List<Fertilization> getFertilizationForCalendar(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("plantId") int plantId);
}
