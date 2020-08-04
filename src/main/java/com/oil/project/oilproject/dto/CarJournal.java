package com.oil.project.oilproject.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "LOG_TIME_INCOME_AREA", schema = "oil")
public class CarJournal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DATE")
    private LocalDateTime dateTime;
    @Column(name = "IMAGE")
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;


}