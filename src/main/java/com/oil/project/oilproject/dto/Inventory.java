package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "INVENTORY", schema = "oil")
@Data
public class Inventory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "CAPACITY")
    private Double capacity;
    @Column(name = "MASS")
    private Double mass;
    @Column(name = "DENSITY")
    private Double density;
}
