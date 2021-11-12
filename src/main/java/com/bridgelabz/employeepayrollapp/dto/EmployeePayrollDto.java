package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;


public @ToString
class EmployeePayrollDto {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "INVALID EMPLOYEE NAME !!!")
    public String empName;

    @Min(value = 500, message = "MINIMUM WAGE SHOULD BE MORE THAN 500")
    public long salary;

    @Pattern(regexp = "male|female|third", message = "INVALID ENTRY FOR GENDER !!! ")
    public String gender;

    @JsonFormat(pattern ="dd MMM yyyy")
    @NotNull(message = "DATE CANNOT BE EMPTY !!!")
    @PastOrPresent(message = "startDate should be past or today's date !!! ")
    public LocalDate startDate;

    @NotBlank(message = "NOTE CANNOT BE BLANK !!!")
    public String note;

    @NotNull(message = "DEPARTMENT SHOULD NOT BE EMPTY !!!")
    public List<String> departments;

    @NotBlank(message ="PLEASE ADD A PROFILE PICTURE !!!" )
    public String profilePic;
}