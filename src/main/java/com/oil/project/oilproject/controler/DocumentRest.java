package com.oil.project.oilproject.controler;

import com.oil.project.oilproject.dto.Petrol;
import com.oil.project.oilproject.dto.document.Document;
import com.oil.project.oilproject.repository.PetrolTypeRepository;
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
public class DocumentRest {
    private final DocumentService documentService;

    @RequestMapping(
            value={"/api/document"},
            produces = {"application/json"},
            method = {RequestMethod.POST}

    )
    public ResponseEntity<Document> save(MultipartFile file ) throws IOException { ;
        documentService.save(file) ;
    return new ResponseEntity<>(HttpStatus.OK);

    };

    @RequestMapping(
            value={"/api/document"},
            produces = {"application/json"},
            method = {RequestMethod.GET}

    )
    public ResponseEntity<List<Document>> findAll() { ;
        return ResponseEntity.ok(documentService.findAll());

    };
}
