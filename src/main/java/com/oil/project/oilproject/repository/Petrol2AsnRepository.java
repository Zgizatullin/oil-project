package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.Asn;
import com.oil.project.oilproject.dto.Petrol;
import com.oil.project.oilproject.dto.Petrol2Asn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Petrol2AsnRepository extends JpaRepository<Petrol2Asn, Long> {
     Petrol2Asn findByPetrolAndAsn(Petrol petrol, Asn asn);
}
