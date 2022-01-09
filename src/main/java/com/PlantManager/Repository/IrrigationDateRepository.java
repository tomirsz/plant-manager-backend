package com.PlantManager.Repository;

import com.PlantManager.Entity.IrrigationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface IrrigationDateRepository extends JpaRepository<IrrigationDate, Long> {

    @Query(value = "SELECT * FROM irrigation_date where date >= :dateFrom or date <= :dateTo and user_id = :userId",
            nativeQuery = true)
    List<IrrigationDate> getIrrigationDateForCalendar(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("userId") long userId);

    @Query(value = "SELECT * FROM irrigation_date where date >= :dateFrom or date <= :dateTo and plant_id = :plantId",
            nativeQuery = true)
    List<IrrigationDate> getIrrigationDateForCalendar(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("plantId") int plantId);
}
