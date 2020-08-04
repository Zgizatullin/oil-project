package com.oil.project.oilproject.controler;

import com.oil.project.oilproject.dto.Petrol;
import com.oil.project.oilproject.repository.PetrolTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
public class PetrolRest {

    private final PetrolTypeRepository petrolTypeRepository;


    @RequestMapping(
            value={"/api/petroll"},
            produces = {"application/json"},
            method = {RequestMethod.GET}

    )
    public List<Petrol> getAll(){
        return petrolTypeRepository.findAll();

    };

}
