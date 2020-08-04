package com.oil.project.oilproject.controler;

import com.oil.project.oilproject.dto.Petrol2Asn;
import com.oil.project.oilproject.dto.document.Document;
import com.oil.project.oilproject.service.DictionaryService;
import com.oil.project.oilproject.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DictionaryRest {
    private final DictionaryService dictionaryService;
    @RequestMapping(
            value={"/api/dictionary/petrol"},
            produces = {"application/json"},
            method = {RequestMethod.POST}

    )
    public ResponseEntity savePetrol(MultipartFile file ) throws IOException { ;
        dictionaryService.savePetrol(file); ;
        return new ResponseEntity<>(HttpStatus.OK);

    };

    @RequestMapping(
            value={"/api/dictionary/asn"},
            produces = {"application/json"},
            method = {RequestMethod.POST}

    )
    public ResponseEntity saveAsn(MultipartFile file ) throws IOException { ;
        dictionaryService.saveAsn(file); ;
        return new ResponseEntity<>(HttpStatus.OK);

    };

    @RequestMapping(
            value={"/api/dictionary/petrol2asn"},
            produces = {"application/json"},
            method = {RequestMethod.POST}

    )
    public ResponseEntity savePetrolToAsn(MultipartFile file ) throws IOException { ;
        dictionaryService.savePetrolToAsn(file); ;
        return new ResponseEntity<>(HttpStatus.OK);

    };

    @RequestMapping(
            value={"/api/dictionary/petrol2asn"},
            produces = {"application/json"},
            method = {RequestMethod.GET}

    )
    public ResponseEntity getAllPetrol2Asn() throws IOException { ;

        return ResponseEntity.ok(dictionaryService.getAllAsn2PetrolDictionary());

    };
    @RequestMapping(
            value={"/api/dictionary/petrol"},
            produces = {"application/json"},
            method = {RequestMethod.GET}

    )
    public ResponseEntity getAllPetrol() throws IOException { ;

        return ResponseEntity.ok(dictionaryService.getAllPetrolDictionary());

    };

    @RequestMapping(
            value={"/api/dictionary/asn"},
            produces = {"application/json"},
            method = {RequestMethod.GET}

    )
    public ResponseEntity getAllAsn() throws IOException { ;

        return ResponseEntity.ok(dictionaryService.getAllAsnDictionary());

    };
    @RequestMapping(
            value={"/api/dictionary/storage"},
            produces = {"application/json"},
            method = {RequestMethod.GET}

    )
    public ResponseEntity getAllStorage() throws IOException { ;

        return ResponseEntity.ok(dictionaryService.getAllStorage());

    };
}
