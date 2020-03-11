package com.example.zoo.persistence.repository;

import com.example.zoo.persistence.model.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageRepository extends JpaRepository<Cage,Long> {
}
