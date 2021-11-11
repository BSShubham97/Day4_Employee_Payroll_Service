package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;

@Data
public class EmployeePayrollData {
private int empId;
private String empName;
private long salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto) {
        this.empId = empId;
        this.empName= employeePayrollDto.empName;
        this.salary=employeePayrollDto.salary;
    }
}
