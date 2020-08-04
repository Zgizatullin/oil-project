package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.document.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String name);
}
