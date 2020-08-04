package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.Petrol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetrolTypeRepository extends JpaRepository<Petrol, Long> {
    Petrol findByName(String name);
    @Query(value = "select p.name from Petrol p")
     List<String> findNames();


}
