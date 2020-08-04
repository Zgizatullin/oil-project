package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CITY", schema = "oil")
public class City {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
}
