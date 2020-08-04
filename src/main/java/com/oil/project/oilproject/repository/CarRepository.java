package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByNumberTrailer(String numberTrailer);
    Car findByNumber(String number);
}
