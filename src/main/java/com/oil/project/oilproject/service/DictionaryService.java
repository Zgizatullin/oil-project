package com.oil.project.oilproject.service;

import com.oil.project.oilproject.dto.Asn;
import com.oil.project.oilproject.dto.Petrol;
import com.oil.project.oilproject.dto.Petrol2Asn;
import com.oil.project.oilproject.dto.Storage;
import com.oil.project.oilproject.repository.AsnRepository;
import com.oil.project.oilproject.repository.Petrol2AsnRepository;
import com.oil.project.oilproject.repository.PetrolTypeRepository;
import com.oil.project.oilproject.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DictionaryService {
    private final PetrolTypeRepository petrolTypeRepository;
    private final AsnRepository asnRepository;
    private final Petrol2AsnRepository petrol2AsnRepository;
    private final StorageRepository storageRepository;

    @Transactional
    public void savePetrol(MultipartFile file) throws IOException {
        List<String> oldPetroles = petrolTypeRepository.findNames().stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(oldPetroles);
        List<Petrol> newPetroles = new ArrayList<>();
        Workbook workbook = null;
        //Check condition whether file is xlsx or xls
        if (file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")).equalsIgnoreCase(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            workbook = new HSSFWorkbook(file.getInputStream());
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            String name = String.valueOf(row.getCell(1));
            if (!oldPetroles.contains(name.toUpperCase())) {
                Petrol petrol = new Petrol();

                petrol.setName(name);
                petrol.setComment(String.valueOf(row.getCell(2)));
                newPetroles.add(petrol);
            }
        }
        newPetroles.remove(0);

        petrolTypeRepository.saveAll(newPetroles);
    }

    @Transactional
    public void saveAsn(MultipartFile file) throws IOException {
        List<String> oldAsn = asnRepository.findNames().stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(oldAsn);
        List<Asn> newAsns = new ArrayList<>();
        Workbook workbook = null;
        //Check condition whether file is xlsx or xls
        if (file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")).equalsIgnoreCase(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            workbook = new HSSFWorkbook(file.getInputStream());
        }
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            String name = String.valueOf(row.getCell(1));
            if (!oldAsn.contains(name.toUpperCase())) {
                Asn asn = new Asn();

                asn.setName(name);
                asn.setComment(String.valueOf(row.getCell(2)));
                newAsns.add(asn);
            }
        }
        newAsns.remove(0);

        asnRepository.saveAll(newAsns);
    }

    @Transactional
    public void savePetrolToAsn(MultipartFile file) throws IOException {

        Workbook workbook = null;
        //Check condition whether file is xlsx or xls
        if (file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")).equalsIgnoreCase(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            workbook = new HSSFWorkbook(file.getInputStream());
        }
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.rowIterator();
        List<Petrol2Asn> petrol2Asns = new ArrayList<>();
        rows.next();
        while (rows.hasNext()) {
            Row row = rows.next();
            Asn asn = asnRepository.findByName(String.valueOf(row.getCell(1)));
            Petrol petrol = petrolTypeRepository.findByName(String.valueOf(row.getCell(2)));
            if (asn != null && petrol != null) {
                Petrol2Asn petrol2Asn = petrol2AsnRepository.findByPetrolAndAsn(petrol, asn);
                if (petrol2Asn == null) {
                    petrol2Asn = new Petrol2Asn();
                    petrol2Asn.setAsn(asn);
                    petrol2Asn.setPetrol(petrol);
                    petrol2Asn.setComment(String.valueOf(row.getCell(2)));
                    petrol2Asns.add(petrol2Asn);
                }

            }
        }

        petrol2AsnRepository.saveAll(petrol2Asns);
    }

    public List<Petrol> getAllPetrolDictionary() {
        return petrolTypeRepository.findAll();
    }

    public List<Asn> getAllAsnDictionary() {
        return asnRepository.findAll();
    }

    public List<Petrol2Asn> getAllAsn2PetrolDictionary() {
        return petrol2AsnRepository.findAll();
    }

    public List<Storage>  getAllStorage(){
        return storageRepository.findAll();
    };
}
