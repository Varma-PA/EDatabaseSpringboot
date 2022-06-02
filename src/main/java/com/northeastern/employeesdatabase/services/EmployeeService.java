package com.northeastern.employeesdatabase.services;

import com.northeastern.employeesdatabase.dao.EmployeeDao;
import com.northeastern.employeesdatabase.dto.EmployeeDTO;
import com.northeastern.employeesdatabase.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee createEmployee(EmployeeDTO employeeDTO){

        System.out.println("Inside Create Employee");

        Employee employee = new Employee();

        employee.setName(employeeDTO.getEmployeeName());
        employee.setDepartment(employeeDTO.getEmployeeDepartment());

        return employeeDao.save(employee);

//        return null;
    }

    public Employee createEmployee(Employee employee){
        return employeeDao.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }


}
