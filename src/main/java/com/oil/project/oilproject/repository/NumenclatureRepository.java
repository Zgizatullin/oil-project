package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.document.EmployeeType;
import com.oil.project.oilproject.dto.document.Numenclature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumenclatureRepository extends JpaRepository<Numenclature, Long> {
}
