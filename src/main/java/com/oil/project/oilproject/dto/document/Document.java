package com.oil.project.oilproject.dto.document;

import com.oil.project.oilproject.dto.Car;
import com.oil.project.oilproject.dto.CarType;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "DOCUMENT", schema = "oil")
public class Document {
    @Id
    @Column(name = "DOC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;
    @Column(name = "DOC_NUMBER")
    private String number;
    @Column(name = "DATE")
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;
    @Column(name = "WAYBILL")
    private String waybill;
    @Column(name = "CODE")
    private String code;
    @Column(name = "SERIA")
    private String seria;
    @ManyToOne
    @JoinColumn(name = "CARRIER_ID")
    private Company carrier;
    @ManyToOne
    @JoinColumn(name = "SHIPPER_ID")
    private Company shipper;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Company customer;
    @ManyToOne
    @JoinColumn(name = "DRIVER_ID")
    private Employee driver;
    @ManyToOne
    @JoinColumn(name = "AZS_ID")
    private Azs azs;
    @ManyToOne
    @JoinColumn(name = "CAR_TYPE_ID")
    private CarType carType;
    @ManyToOne
    @JoinColumn(name = "CAR_TYPE_EXTRA_ID")
    private CarType carExtraType;
    @ManyToOne
    @JoinColumn(name = "RECEIVER_ID")
    private Company receiver;
    @Column(name = "LOAD")
    private String load;
    @Column(name = "UNLOAD")
    private String unload;
    @Column(name = "READDRESSING")
    private String reAddressing;
    @Column(name = "READDRESSING_TRANSPORT")
    private String reAddressingTransport;
    @ManyToOne
    @JoinColumn(name = "UNLOAD_AZS_ID")
    private Azs unloadAzs;
    @ManyToOne
    @JoinColumn(name = "LOAD_AZS_ID")
    private Azs loadAzs;
    @Column(name = "TOTAL_COUNT")
    private Double totalCount;
    @Column(name = "TOTAL_MASS_GROSS")
    private Double totalMassGross;
    @Column(name = "TOTAL_SUMM")
    private Double totalSumm;
    @Column(name = "TOTAL_SUMM_CHAR")
    private String totalSummString;
    @Column(name = "POINT_WEIGH_CHECK_COUNT")
    private Integer pointWeighCheckCount;
    @Column(name = "POINT_WEIGH_CHECK_PlACE")
    private Integer pointWeighCheckPlace;
    @Column(name = "FINAL_TOTAL_MASS_GROSS")
    private Double finalTotalMassGross;
    @Column(name = "PASSED_EMPLOYEE_ID")
    private String passedEmployee;
    @Column(name = "GOT_EMPLOYEE_ID")
    private String gotEmployee;
    @Column(name = "MUNDER_NUN")
    private String munderNum;
    @Column(name = "MUNDER_DESCRIPTION")
    private String munderDescription;
    @ManyToOne
    @JoinColumn(name = "FINAL_PASSED_EMPLOYEE_ID")
    private Employee finalPassedEmployee;
    @ManyToOne
    @JoinColumn(name = "FINAL_GOT_EMPLOYEE_ID")
    private Employee finalGotEmployee;

    @OneToMany( mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Numenclature> numenclatureList;
}

