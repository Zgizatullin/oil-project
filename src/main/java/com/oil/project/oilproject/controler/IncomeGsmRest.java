package com.oil.project.oilproject.controler;

import com.oil.project.oilproject.dto.StorageHistoryHeader;
import com.oil.project.oilproject.dto.api.IncomeGSM;
import com.oil.project.oilproject.service.IncomeGmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IncomeGsmRest {
 private final IncomeGmsService incomeGmsService;


    @RequestMapping(
            value={"/api/incomegsm"},
            produces = {"application/json"},
            consumes = {"application/json"},
            method = {RequestMethod.POST}

    )
    public ResponseEntity<String> save(@RequestBody IncomeGSM incomeGSM ){
        incomeGmsService.save(incomeGSM);

        return ResponseEntity.ok("record was saved");

    };
    @RequestMapping(
            value={"/api/incomegsm"},
            produces = {"application/json"},
            method = {RequestMethod.GET}

    )
    public List<StorageHistoryHeader> findAll(){
        return incomeGmsService.findAll();

    };
}
