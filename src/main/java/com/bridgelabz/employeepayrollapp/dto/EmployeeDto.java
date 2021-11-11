package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private int empId;
    private String empName;
    private long salary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public EmployeeDto(int empId, String empName, long salary) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDto [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
    }


}