package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    List<EmployeePayrollData> employeePayrolltList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrolltList;
    }


    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrolltList.get(empId - 1);
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrolltList.size() + 1, employeePayrollDto);
        employeePayrolltList.add(empData);
        return empData;
    }


    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setEmpName(employeePayrollDto.empName);
        empData.setSalary(employeePayrollDto.salary);
        employeePayrolltList.set(empId - 1, empData);
        return empData;
    }


    public void deleteEmployeePayrollData(int empId) {
        employeePayrolltList.remove(empId - 1);
    }
}
