package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import com.bridgelabz.employeepayrollapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
     private EmployeePayrollRepository employeeRepository;
    @Autowired
    TokenUtil  tokenUtil;

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


    public EmployeePayrollData updateEmployeePayrollData(String token, EmployeePayrollDto employeePayrollDto) {
        Integer Id= tokenUtil.decodeToken(token);
        Optional<EmployeePayrollData> empData = employeeRepository.findById(Id);
        if(empData.isPresent()) {
            empData.get().setEmpName(employeePayrollDto.empName);
            empData.get().setDepartments(employeePayrollDto.departments);
            empData.get().setGender(employeePayrollDto.gender);
            empData.get().setSalary(employeePayrollDto.salary);
            empData.get().setProfilePic(employeePayrollDto.profilePic);
            empData.get().setStartDate(employeePayrollDto.startDate);
            empData.get().setNote(employeePayrollDto.note);
            employeeRepository.save(empData.get());
            return empData.get();
        }
        return null;
    }

    public String deleteEmployeePayrollData(String token) {
            Integer Id = tokenUtil.decodeToken(token);
            Optional<EmployeePayrollData> empData = employeeRepository.findById(Id);
            if(empData.isPresent()) {
                employeeRepository.delete(empData.get());
            }
            return null;
        }

    @Override
    public List<EmployeePayrollData> getAllEmployeeData(String token) {
        Integer Id = tokenUtil.decodeToken(token);
        Optional<EmployeePayrollData> empData = employeeRepository.findById(Id);
        if(empData.isPresent()) {
            return employeeRepository.findAll();
        }
        return null;
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeeRepository.findEmployeesDataByDepartment(department);
    }
}
