package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

@Data
public class EmployeePayrollDto {


    public String empName;
    public long salary;

    public EmployeePayrollDto(String empName,long salary) {
        this.empName=empName;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDto [empName=" + empName + ", salary=" + salary + "]";
    }
}