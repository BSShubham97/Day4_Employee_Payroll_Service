package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


public @Data
class EmployeePayrollData {
    private int empId;
    private String empName;
    private long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> departments;


    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto) {
        this.empId = empId;
        this.updateEmployeePayrollData(employeePayrollDto);
    }

    public void updateEmployeePayrollData(EmployeePayrollDto empPayrollDto) {
        this.empName = empPayrollDto.empName;
        this.salary = empPayrollDto.salary;
        this.gender = empPayrollDto.gender;
        this.startDate = empPayrollDto.startDate;
        this.note = empPayrollDto.note;
        this.profilePic=empPayrollDto.profilePic;
        this.departments = empPayrollDto.departments;
    }
}
