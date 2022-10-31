package com.example.UtilitySerivce.repository;

import com.example.UtilitySerivce.entites.Utility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityRepository extends JpaRepository<Utility, Integer> {
    Utility findByUtilityName(String utilityName);
}
