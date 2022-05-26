package com.ioco.assignment.repository;

import com.ioco.assignment.domain.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {

    /**
     * @return the number of records updated. It should be 1 for us against a valid survivor id
     */
    @Modifying
    @Query("UPDATE Survivor SET latitude = ?2, longitude = ?3 WHERE id = ?1")
    int updateLocation(long survivorId, double latitude, double longitude);
}
