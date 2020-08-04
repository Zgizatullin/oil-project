package com.oil.project.oilproject.dto.document;

import lombok.Data;

import javax.persistence.*;

//
@Entity
@Data
@Table(name = "COMPANY", schema = "oil")
public class Company {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String  address;

}
