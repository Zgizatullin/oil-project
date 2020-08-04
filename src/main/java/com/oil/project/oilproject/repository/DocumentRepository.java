package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    public Document findByNumber(String number);
}
