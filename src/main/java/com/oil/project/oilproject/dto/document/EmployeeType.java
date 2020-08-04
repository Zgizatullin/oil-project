package com.oil.project.oilproject.dto.document;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

//
@Entity
@Data
@Table(name = "EMPLOYEE_TYPE", schema = "oil")
public class EmployeeType {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "COMMENT")
    private String  comment;
}
