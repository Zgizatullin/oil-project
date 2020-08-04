package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MODEL_CAR", schema = "oil")
@Data
public class ModelCar {
    @Id
    @Column(name = "MODEL_CAR_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long modelCarId;
    @Column(name = "name")
    private String name;
}
