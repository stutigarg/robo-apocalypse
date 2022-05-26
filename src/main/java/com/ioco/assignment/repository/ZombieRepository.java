package com.ioco.assignment.repository;

import com.ioco.assignment.domain.Zombie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZombieRepository extends JpaRepository<Zombie, Long> {
}
