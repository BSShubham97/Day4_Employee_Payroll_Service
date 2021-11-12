package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDto respDto = new ResponseDto("GET CALL FOR ID SUCCESSFUL", empDataList);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDto respDto = new ResponseDto("GET CALL FOR ID SUCCESSFUL", empData);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);

        // GET http://localhost:8080/employeepayrollservice/get/3
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDto);
        ResponseDto respDto = new ResponseDto("CREATED EMPLOYEE DATA SUCCESSFULLY !!! ", empData);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    /*
    POST http://localhost:8080/employeepayrollservice/create
    Body- raw (JSON)- {"empName":"Shubham","salary":"2000"}
     */
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @Valid@RequestBody EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDto);
        ResponseDto respDto = new ResponseDto("UPDATED EMPLOYEE DATA SUCCESSFULLY !!! ", empData);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDto responseDto = new ResponseDto("Deleted Employee Payroll Data SUCCESSFULLY !!!", "Deleted_ID =" + empId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

}