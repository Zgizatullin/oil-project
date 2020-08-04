package com.oil.project.oilproject.dto.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oil.project.oilproject.dto.Petrol;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "NOMENCLATURE", schema = "oil")
public class Numenclature {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "DOC_ID")
    @JsonIgnore
    private Document document;
    @Column(name = "NUM_NUMBER")
    private String numNumber;
    @ManyToOne
    @JoinColumn(name = "PETROL_ID")
    private Petrol petrol;
    @ManyToOne
    @JoinColumn(name = "UNIT_ID")
    private Unit unit;
    @Column(name = "COUNT")
    private Double count;
    @Column(name = "SPECIFIC_WEIGHT")
    private Double specificWeigh;
    @Column(name = "TEMPERATURE")
    private Double temperature;
    @Column(name = "MASS_GROSS")
    private Double massGross;

}
