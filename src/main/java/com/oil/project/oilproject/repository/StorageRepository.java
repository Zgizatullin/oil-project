package com.oil.project.oilproject.repository;

import com.oil.project.oilproject.dto.Storage;
import com.oil.project.oilproject.dto.document.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository  extends JpaRepository<Storage, Long> {
}
