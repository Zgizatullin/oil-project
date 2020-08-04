package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

//
@Entity
@Data
@Table(name = "CAR", schema = "oil")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "NUMBER_TRAILER")
    private String  numberTrailer;
}
