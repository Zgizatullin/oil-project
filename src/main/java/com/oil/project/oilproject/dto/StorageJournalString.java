package com.oil.project.oilproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "STORAGE_JOURNAL_STRING", schema = "oil")
public class StorageJournalString {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "volume")
    private Double volume;
    @Column(name = "density")
    private Double density;
    @Column(name = "mass")
    private Double mass;
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "HEADER_ID")
    @JsonIgnore
    private StorageHistoryHeader storageHistoryHeader;
    //todo fix deferent beetween fields
    @Transient
//    @Column(name = "metering_type")
    private int manualy;

}
