package com.PlantManager.Repository;

import com.PlantManager.Entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface FormationRepository extends JpaRepository<Formation, Long> {
    @Query(value = "SELECT * FROM formation where date_from >= :dateFrom or date_to <= :dateTo and user_id = :userId",
            nativeQuery = true)
    List<Formation> getFormationForCalendar(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("userId") long userId);

    @Query(value = "SELECT * FROM formation where date_from >= :dateFrom or date_to <= :dateTo and plant_id = :plantId",
            nativeQuery = true)
    List<Formation> getFormationForCalendar(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo, @Param("plantId") int plantId);
}
