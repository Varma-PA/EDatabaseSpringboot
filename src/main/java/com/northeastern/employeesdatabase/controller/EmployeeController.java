package com.northeastern.employeesdatabase.controller;

import com.northeastern.employeesdatabase.dto.EmployeeDTO;
import com.northeastern.employeesdatabase.entities.Employee;
import com.northeastern.employeesdatabase.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        @GetMapping
        public ModelAndView showHomeScreen(){
            ModelAndView modelAndView = new ModelAndView("HomeScreen");
            return modelAndView;
        }

        @GetMapping("/list")
        public ModelAndView showEmployees(){
            ModelAndView modelAndView = new ModelAndView("ListEmployees");
            List<Employee> employeesList = employeeService.getAllEmployees();
            modelAndView.addObject("employees", employeesList);
            return modelAndView;
        }

        @GetMapping("/add")
        public ModelAndView addEmployeeForm(){

            ModelAndView modelAndView = new ModelAndView("AddEmployee");
            EmployeeDTO employeeDTO = new EmployeeDTO();
//            Employee employee = new Employee();
            modelAndView.addObject("employee", employeeDTO);
//            employeeService.createEmployee(employee);
            System.out.println(employeeDTO);

            return modelAndView;
        }

        @PostMapping("/saveEmployee")
        public String saveEmployee(@ModelAttribute EmployeeDTO employeeDTO){
            System.out.println(employeeDTO);
            employeeService.createEmployee(employeeDTO);
            return "redirect:/list";
        }

}
