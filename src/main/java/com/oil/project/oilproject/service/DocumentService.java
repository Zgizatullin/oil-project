package com.oil.project.oilproject.service;

import com.oil.project.oilproject.dto.Car;
import com.oil.project.oilproject.dto.document.*;
import com.oil.project.oilproject.repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final CarRepository carRepository;
    private final CompanyRepository companyRepository;
    private final EmployeeTypeRepository employeeTypeRepository;
    private final EmployeeRepository employeeRepository;
    private final PetrolTypeRepository petrolTypeRepository;
    private final UnitRepository unitRepository;
    private final DocumentRepository documentRepository;
    private final NumenclatureRepository numenclatureRepository;
    private String fileLocation;
    public static final String FIRST_ROW = "ТОВАРО-ТРАНСПОРТНАЯ НАКЛАДНАЯ №";

    @Transactional
    public Document save(MultipartFile file) throws IOException {
        List<Numenclature> numenclatures = new ArrayList<>();
        InputStream in = file.getInputStream();
        File currDir = new File(".");
        Workbook workbook = null;
        Document document = new Document();
        //Check condition whether file is xlsx or xls
        if (file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")).equalsIgnoreCase(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        Sheet sheet = workbook.getSheetAt(0);
        Row firstRow = sheet.getRow(0);
        Cell firstCell = firstRow.getCell(1);
        if (firstCell.getStringCellValue().trim().equalsIgnoreCase(FIRST_ROW)) {
            document.setNumber(firstRow.getCell(2).getStringCellValue());
            String carValue = sheet.getRow(4).getCell(1).toString();
            Car carMain = carRepository.findByNumber(carValue);
            if (carMain == null) {
                carMain = new Car();
                carMain.setNumber(carValue);
                carMain.setNumberTrailer(carValue);
                carMain = carRepository.save(carMain);

            }
            document.setCar(carMain);
            String carrierName = sheet.getRow(7).getCell(1).getStringCellValue();
            Company carrier = companyRepository.findByName(carrierName);
            if (carrier == null) {
                carrier = new Company();
                carrier.setAddress(carrierName);
                carrier.setName(carrierName);
                carrier = companyRepository.save(carrier);
            }
            document.setCarrier(carrier);
            EmployeeType driverType = employeeTypeRepository.findByName("водитель");
            document.setDriver(getEmployee(sheet.getRow(7).getCell(6).toString().trim(), driverType));

            document.setWaybill(sheet.getRow(4).getCell(6).getStringCellValue());
            document.setSeria(String.valueOf(sheet.getRow(4).getCell(7).getNumericCellValue()));
            document.setCode(String.valueOf(sheet.getRow(4).getCell(9).getNumericCellValue()));
            String customerName = sheet.getRow(7).getCell(1).getStringCellValue();
            Company customer = companyRepository.findByName(customerName);
            if (customer == null) {
                customer = new Company();
                customer.setAddress(customerName);
                customer.setName(customerName);
                customer = companyRepository.save(customer);
            }
            document.setCustomer(customer);

            String reciverName = sheet.getRow(13).getCell(2).getStringCellValue();
            Company reciver = companyRepository.findByName(reciverName);
            if (reciver == null) {
                reciver = new Company();
                reciver.setAddress(reciverName);
                reciver.setName(reciverName);
                reciver = companyRepository.save(reciver);
            }
            document.setReceiver(reciver);

            String shipperName = sheet.getRow(11).getCell(2).getStringCellValue();
            Company shipper = companyRepository.findByName(shipperName);
            if (shipper == null) {
                shipper = new Company();
                shipper.setAddress(shipperName);
                shipper.setName(shipperName);
                shipper = companyRepository.save(shipper);
            }
            document.setShipper(shipper);
            document.setLoad(sheet.getRow(15).getCell(2).getStringCellValue());
            document.setUnload(sheet.getRow(15).getCell(7).getStringCellValue() +
                    " " + String.valueOf(sheet.getRow(15).getCell(8)));
            document.setReAddressing(String.valueOf(sheet.getRow(17).getCell(2)));
            document.setReAddressingTransport(String.valueOf(sheet.getRow(17).getCell(8)));
            int startRecordNum = 23;

            while (!Strings.isEmpty(sheet.getRow(startRecordNum).getCell(0).toString()) ||
                    !Strings.isEmpty(sheet.getRow(startRecordNum).getCell(2).toString()) ||
                    !Strings.isEmpty(sheet.getRow(startRecordNum).getCell(9).toString())) {
                if (!String.valueOf(sheet.getRow(startRecordNum).getCell(2)).equalsIgnoreCase("ИТОГО")) {
                    if (!Strings.isEmpty(sheet.getRow(startRecordNum).getCell(0).toString())) {
                        Numenclature numenclature = new Numenclature();
                        numenclature.setCount(sheet.getRow(startRecordNum).getCell(5).getNumericCellValue());
                        numenclature.setPetrol(petrolTypeRepository.findByName(sheet.getRow(startRecordNum).getCell(2).getStringCellValue()));
                        numenclature.setMassGross(sheet.getRow(startRecordNum).getCell(9).getNumericCellValue());
                        numenclature.setSpecificWeigh(sheet.getRow(startRecordNum).getCell(7).getNumericCellValue());
                        numenclature.setTemperature(sheet.getRow(startRecordNum).getCell(8).getNumericCellValue());
                        Unit unit = unitRepository.findByName(sheet.getRow(startRecordNum).getCell(4).getStringCellValue());
                        if (unit == null) {
                            unit = new Unit();
                            unit.setName(sheet.getRow(startRecordNum).getCell(4).getStringCellValue());
                            unit = unitRepository.save(unit);
                        }
                        numenclature.setUnit(unit);
                        numenclature.setNumNumber(sheet.getRow(startRecordNum).getCell(0).getStringCellValue());
                        startRecordNum++;
                        numenclatures.add(numenclature);
                    } else {
                        startRecordNum++;
                    }
                } else {
                    document.setTotalCount(sheet.getRow(startRecordNum).getCell(4).getNumericCellValue());
                    document.setTotalCount(sheet.getRow(startRecordNum).getCell(9).getNumericCellValue());

                    startRecordNum += 3;
                    break;
                }

            }

            String pointWeighCheckCount = sheet.getRow(startRecordNum).getCell(3).toString();
            if (!Strings.isEmpty(pointWeighCheckCount)) {
                document.setPointWeighCheckCount(Integer.valueOf(pointWeighCheckCount));
            }
            startRecordNum++;
            String pointWeighCheckPlace = sheet.getRow(startRecordNum).getCell(3).toString();
            if (!Strings.isEmpty(pointWeighCheckPlace)) {
                document.setPointWeighCheckPlace(Integer.valueOf(pointWeighCheckPlace));
            }
            startRecordNum += 4;
            document.setPassedEmployee(sheet.getRow(startRecordNum).getCell(1).toString());
            startRecordNum += 2;
            document.setGotEmployee(sheet.getRow(startRecordNum).getCell(4).toString());
            startRecordNum += 5;
            String driver1 = sheet.getRow(startRecordNum).getCell(2).getStringCellValue().trim();
            EmployeeType driverType1 = employeeTypeRepository.findByName("Водитель");

            document.setFinalGotEmployee(getEmployee(driver1, driverType1));
            startRecordNum += 2;

            document.setFinalGotEmployee(getEmployee(sheet.getRow(startRecordNum).getCell(3).toString().trim(), driverType));
            document = documentRepository.save(document);
            final Document doc = document;
            numenclatures.forEach(numenclature -> {
                numenclature.setDocument(doc);
            });
            document.setNumenclatureList(numenclatures);

            document = documentRepository.save(document);

        }
        return document;
    }

    private Employee getEmployee(String name, EmployeeType employeeType) {


        String firstName1 = new String();
        String lastName1 = new String();
        String middleName1 = new String();
        Employee driverEmployee1 = null;
        if (!Strings.isEmpty(name)) {
            String[] names = name.split(" ");

            lastName1 = names[0];
            if (names.length > 1) {
                firstName1 = names[1];
                if (names.length > 2) {
                    middleName1 = names[2];
                }
            }
            if (!Strings.isEmpty(firstName1) && !Strings.isEmpty(lastName1) && !Strings.isEmpty(middleName1)) {
                driverEmployee1 = employeeRepository.findByFirstNameAndLastNameAndMiddleName(firstName1, lastName1, middleName1);
            } else if (!Strings.isEmpty(firstName1) && !Strings.isEmpty(lastName1)) {
                driverEmployee1 = employeeRepository.findByFirstNameAndLastName(firstName1, lastName1);
            } else {
                driverEmployee1 = employeeRepository.findByLastName(lastName1);
            }
            if (driverEmployee1 == null) {
                driverEmployee1 = new Employee();
                driverEmployee1.setEmployeeType(employeeType);
                driverEmployee1.setFirstName(firstName1);
                driverEmployee1.setLastName(lastName1);
                driverEmployee1.setMiddleName(middleName1);
                driverEmployee1 = employeeRepository.save(driverEmployee1);
            }

        }

        return driverEmployee1;

    }


    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    public Document findById(Long id) {
        return documentRepository.findById(id).get();
    }
}
