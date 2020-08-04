package com.oil.project.oilproject.dto.document;

import lombok.Data;

import javax.persistence.*;

//
@Entity
@Data
@Table(name = "UNIT", schema = "oil")
public class Unit {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "comment")
    private String  comment;

}
