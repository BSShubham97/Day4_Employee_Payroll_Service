package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employee_payroll")
public @Data class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    private int empId;

    @Column(name = "name")
    private String empName;

    private long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;

    @ElementCollection
    @CollectionTable(name="employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    public List<String> departments;


    public EmployeePayrollData() {
    }

    public EmployeePayrollData( EmployeePayrollDto employeePayrollDto) {
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
