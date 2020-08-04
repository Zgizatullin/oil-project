package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.Asn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AsnRepository extends JpaRepository<Asn, Long> {
    @Query(value = "select a.name from Asn a")
    public List<String> findNames();
    Asn findByName(String name);
}
