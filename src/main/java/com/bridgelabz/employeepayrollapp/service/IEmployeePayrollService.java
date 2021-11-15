package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto);

    EmployeePayrollData updateEmployeePayrollData(String token , EmployeePayrollDto employeePayrollDto);

    String deleteEmployeePayrollData(String token);

    List<EmployeePayrollData> getAllEmployeeData(String token);

    List<EmployeePayrollData> getEmployeesByDepartment(String department);

}
