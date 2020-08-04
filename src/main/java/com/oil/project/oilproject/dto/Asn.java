package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ASN", schema = "oil")
public class Asn {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "comment")
    private String comment;
}
