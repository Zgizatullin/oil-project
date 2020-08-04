package com.oil.project.oilproject.service;

import com.google.common.collect.Lists;
import com.oil.project.oilproject.dto.*;
import com.oil.project.oilproject.dto.api.IncomeGSM;
import com.oil.project.oilproject.dto.document.Document;
import com.oil.project.oilproject.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeGmsService {
    private final DocumentRepository documentRepository;
    private final PetrolTypeRepository petrolTypeRepository;

    private final AsnRepository asnRepository;
    private final StorageRepository storageRepository;
    private final CarRepository carRepository;


    private final StorageHistoryHeaderRepository storageHistoryHeaderRepository;
    private final StorageJournalStringRepository storageJournalStringRepository;

    @Transactional
    public void save(IncomeGSM incomeGSM) {

        StorageHistoryHeader storageHistoryHeader = new StorageHistoryHeader();
        StorageJournalString storageJournalString = new StorageJournalString();
        storageHistoryHeader.setDate(incomeGSM.getStartDate());
        Document document = documentRepository.findByNumber(incomeGSM.getDocNum());

        if (document != null) {
            storageHistoryHeader.setDocId(document.getDocId());
        }
        Optional<Petrol> petrol = petrolTypeRepository.findById(incomeGSM.getPetrolId());
        if (petrol.isPresent()) {
            storageHistoryHeader.setPetrol(petrol.get());
        }
        Optional<Asn> asn = asnRepository.findById(incomeGSM.getCisternId());
        storageHistoryHeader.setCar(carRepository.findById(1L).get());
        if (asn.isPresent()) {

            storageHistoryHeader.setAsn(asnRepository.findById(incomeGSM.getCisternId()).get());
        }
        storageHistoryHeader.setManualy(incomeGSM.getManualy());
        storageHistoryHeader.setIncome(incomeGSM.getIncome());
        Optional<Storage> storage=storageRepository.findById(incomeGSM.getStorageId());
        if(storage.isPresent()){
        storageHistoryHeader.setStorage(storage.get());}

        storageHistoryHeader.setComment(incomeGSM.getComment());

       storageHistoryHeader.setInvoiceNumber(incomeGSM.getInoviceNumber());

        storageJournalString.setComment(incomeGSM.getComment());
        storageJournalString.setDate(incomeGSM.getStartDate());
        storageJournalString.setManualy(incomeGSM.getManualy());
        storageJournalString.setDensity(incomeGSM.getDensity());
        storageJournalString.setMass(incomeGSM.getMass());
        storageJournalString.setVolume(incomeGSM.getVolume());
        storageJournalString.setStorageHistoryHeader(storageHistoryHeader);
//        storageJournalStringRepository.save(storageJournalString);
        List<StorageJournalString>storageJournalStrings=new ArrayList<>();
        storageJournalStrings.add(storageJournalString);
        storageHistoryHeader.setStorageJournalStrings(storageJournalStrings);
        storageHistoryHeader = storageHistoryHeaderRepository.save(storageHistoryHeader);


    }

    public List<StorageHistoryHeader> findAll() {
        return storageHistoryHeaderRepository.findAll();
    }
}
