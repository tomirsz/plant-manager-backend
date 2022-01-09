package com.PlantManager.Repository;

import com.PlantManager.Entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PlantRepository extends JpaRepository<Plant, Long> {

    Plant save(Plant plant);

    @Query(value = "SELECT * FROM plant where user_id = :userId",
            nativeQuery = true)
    List<Plant> findAll(@Param("userId") long userId);

}
