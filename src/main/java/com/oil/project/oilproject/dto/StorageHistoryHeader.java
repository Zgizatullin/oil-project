package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "STORAGE_HISTORY_HEADER", schema = "oil")
public class StorageHistoryHeader {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "Comment")
    private String comment;
    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;
    @ManyToOne
    @JoinColumn(name = "ASN_ID")
    private Asn asn;
    @ManyToOne
    @JoinColumn(name = "PETROL_TYPE_ID")
    private Petrol petrol;
    //todo fix deferent beetween fields

    @Column(name = "metering_type")
    private Integer manualy;
    @Column(name = "record_type")

    private Integer income;
    @Column(name = "DOC_ID")
    private Long docId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "HEADER_ID")
    private List<StorageJournalString> storageJournalStrings = new ArrayList<>();
}
