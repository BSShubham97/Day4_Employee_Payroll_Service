package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.dto.ResponseDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import com.bridgelabz.employeepayrollapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @Autowired
    TokenUtil tokenUtil;

    @RequestMapping(value = {"", "/", "get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData (@RequestHeader (name="token") String token) {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getAllEmployeeData(token);
        ResponseDto respDto = new ResponseDto("GET CALL FOR ID SUCCESSFUL", empDataList);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataById (@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDto respDto = new ResponseDto("GET CALL FOR ID SUCCESSFUL", empData);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);

        // GET http://localhost:8080/employeepayrollservice/get/3
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDto employeePayrollDto) {
        log.debug("Employee DTO: " + employeePayrollDto.toString());
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDto);
        ResponseDto respDto = new ResponseDto("CREATED EMPLOYEE DATA SUCCESSFULLY !!! ",tokenUtil.createToken(empData.getEmpId())) ;
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    /*
    POST http://localhost:8080/employeepayrollservice/create
    Body- raw (JSON)- {"empName":"Shubham","salary":"2000"}
     */
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@RequestHeader (name="token") String token,
                                                                 @Valid @RequestBody EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(token, employeePayrollDto);
        ResponseDto respDto = new ResponseDto("UPDATED EMPLOYEE DATA SUCCESSFULLY !!! ", empData);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@RequestHeader (name="token") String token)  {
    employeePayrollService.deleteEmployeePayrollData(token);
        ResponseDto responseDto = new ResponseDto("Deleted Employee Payroll Data SUCCESSFULLY !!!","It is Updated in DATABASE");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDto>getEmployeesByDepartment(@PathVariable("department") String department) {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeesByDepartment(department);
        ResponseDto respDto = new ResponseDto("GET CALL FOR ID SUCCESSFUL", empDataList);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

}