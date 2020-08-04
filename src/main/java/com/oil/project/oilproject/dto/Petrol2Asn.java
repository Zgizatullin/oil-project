package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PETROL2ASN", schema = "oil")
@Data
public class Petrol2Asn {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "PETROL_ID")
    private Petrol petrol;
    @ManyToOne
    @JoinColumn(name = "ASN_TYPE_ID")
    Asn asn;
    @Column(name = "comment")
    private String comment;
}
