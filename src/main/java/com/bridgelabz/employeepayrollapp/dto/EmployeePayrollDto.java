package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;


public @ToString
class EmployeePayrollDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "INVALID EMPLOYEE NAME !!!")
    public String empName;

    @Min(value = 500, message = "MINIMUM WAGE SHOULD BE MORE THAN 500")
    public long salary;

    public String gender;

    @JsonFormat(pattern ="dd MMM yyyy")
    public LocalDate startDate;

    public String note;

    public List<String> departments;
    
    public String profilePic;
}