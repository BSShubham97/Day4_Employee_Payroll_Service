package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class EmployeePayrollDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "INVALID EMPLOYEE NAME !!!")
    public String empName;
    @Min(value = 500, message = "MINIMUM WAGE SHOULD BE MORE THAN 500")
    public long salary;

    public EmployeePayrollDto(String empName, long salary) {
        this.empName = empName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDto [empName=" + empName + ", salary=" + salary + "]";
    }
}