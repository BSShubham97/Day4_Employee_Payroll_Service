package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = { "", "/", "get" })
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping ("/get/{empId}")
    public ResponseEntity<String> getEmployeeDataById(@PathVariable int empId) {
        return new ResponseEntity<String>("Get call Succeed for Id : " + empId, HttpStatus.OK);
    // GET http://localhost:8080/employeepayrollservice/get/3
    }


    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<String>("created Employee Payroll Data for : " + employeeDto.toString(), HttpStatus.OK);
    /*
    POST http://localhost:8080/employeepayrollservice/create
    Body- raw (JSON)- {"empName":"Shubham","salary":"2000"}
     */
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<String>("updated Employee Payroll Data for : " + employeeDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable String empId) {
        return new ResponseEntity<String>("deleted Employee Payroll Data for : " + empId, HttpStatus.OK);
    }

}