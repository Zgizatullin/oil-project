package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CAR_TYPE", schema = "oil")
public class CarType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
}
