package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.document.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName);
    Employee findByFirstNameAndLastName(String firstName, String lastName);
    Employee findByLastName( String lastName);
}
