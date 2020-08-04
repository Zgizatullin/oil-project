package com.oil.project.oilproject.dto.api;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class IncomeGSM {
    private String docNum;
    private Long  cisternId;
    private String  rvsNum;
    private Long petrolId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String comment;
    private Integer manualy;
    private Integer income;
    private String inoviceNumber;
    private Long storageId;

    private Double volume;
    private Double density;
    private Double mass;

}
