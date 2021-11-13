package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
     private EmployeePayrollRepository employeeRepository;

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId) {

        return employeeRepository
                .findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("EMPLOYEE WITH ID " +empId+ "NOT FOUND / PRESENT"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData( employeePayrollDto);
        log.debug("EMP DATA: "+empData.toString());
        return employeeRepository.save(empData);
    }


    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto employeePayrollDto) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(employeePayrollDto);
        return employeeRepository.save(empData);
    }

    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
       employeeRepository.delete(empData);

    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeeRepository.findEmployeesDataByDepartment(department);
    }
}
