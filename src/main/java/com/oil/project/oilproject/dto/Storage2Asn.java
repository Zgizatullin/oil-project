package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "STORAGE2ASN", schema = "oil")
public class Storage2Asn {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;
    @ManyToOne
    @JoinColumn(name = "ASN_ID")
    private Asn asn;
    @Column(name = "NUMBER")
    private String number;

}
