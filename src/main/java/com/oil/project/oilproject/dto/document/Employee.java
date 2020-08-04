package com.oil.project.oilproject.dto.document;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

//
@Entity
@Data
@Table(name = "EMPLOYEE", schema = "oil")
public class Employee {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String  lastName;
    @Column(name = "MIDDLE_NAME")
    private String  middleName;
    @Column(name = "BIRTHDAY")
    private LocalDateTime birthDay;
    @ManyToOne
    @JoinColumn(name = "EMPLOY_TYPE_ID")
    private EmployeeType  employeeType;
}
