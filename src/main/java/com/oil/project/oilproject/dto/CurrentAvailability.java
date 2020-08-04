package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CURRENT_AVAILABILITY", schema = "oil")
public class CurrentAvailability {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "STORAGE_TYPE_ID")
    private Storage storageType;
    @ManyToOne
    @JoinColumn(name = "PETROL_TYPE_ID")
    private Petrol petrol;
    @Column(name = "VOLUME")
    private Double volume;
    @Column(name = "MASS")
    private Double mass;
    @Column(name = "DENSITY")
    private Double density;
}
