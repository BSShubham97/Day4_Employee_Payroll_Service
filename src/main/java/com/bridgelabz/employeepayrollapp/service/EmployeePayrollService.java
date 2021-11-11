package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEmployeePayrollService {


    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = new ArrayList<>();
        empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDto("Pankaj", 3000)));
        return empDataList;
    }


    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, new EmployeePayrollDto("Pankaj", 3000));
        return empData;
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDto);
        return empData;
    }


    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDto);
        return empData;
    }


    public void deleteEmployeePayrollData(int empId) {

    }
}
