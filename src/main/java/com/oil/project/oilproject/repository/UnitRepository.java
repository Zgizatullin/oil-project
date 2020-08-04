package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.Petrol;
import com.oil.project.oilproject.dto.document.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Unit findByName(String name);
}
