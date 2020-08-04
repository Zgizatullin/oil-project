package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.document.Employee;
import com.oil.project.oilproject.dto.document.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository  extends JpaRepository<EmployeeType, Long> {
    EmployeeType findByName(String name);
}
