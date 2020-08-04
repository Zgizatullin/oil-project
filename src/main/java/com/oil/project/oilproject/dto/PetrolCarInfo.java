package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PETROL_CAR_INFO", schema = "oil")
@Data
public class PetrolCarInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;
    @ManyToOne
    @JoinColumn(name = "MODEL_CAR_ID")
    private ModelCar modelCar;
    @ManyToOne
    @JoinColumn(name = "CAR_TYPE_ID")
    private CarType carType;
    @Column(name = "YEAR")
    private Integer year;
    @Column(name = "COMPONENT")
    private String component;
    @Column(name = "CAPACITY")
    private Double capacity;
    @Column(name = "ADDITIONAL")
    private String additional;

}
