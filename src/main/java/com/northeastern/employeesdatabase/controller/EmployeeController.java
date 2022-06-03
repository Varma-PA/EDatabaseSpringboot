package com.northeastern.employeesdatabase.controller;

import com.northeastern.employeesdatabase.dto.EmployeeDTO;
import com.northeastern.employeesdatabase.entities.Employee;
import com.northeastern.employeesdatabase.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
            employeeService.createEmployee(employeeDTO);
            return "redirect:/list";
        }

        @PostMapping("/saveUpdatedEmployee")
        public String saveUpdatedEmployee(@ModelAttribute Employee employee){

            employeeService.updateEmployee(employee);
            return "redirect:/list";

        }


        @GetMapping("/showUpdateForm")
        public ModelAndView showUpdateForm(@RequestParam Integer employeeId){
            ModelAndView modelAndView = new ModelAndView("UpdateEmployee");

            Employee employee = employeeService.getEmployeeById(employeeId);

//            EmployeeDTO employeeDTO = new EmployeeDTO();
//
//            employeeDTO.setEmployeeName(employee.getName());
//            employeeDTO.setEmployeeDepartment(employee.getDepartment());

            modelAndView.addObject("employee", employee);

            return modelAndView;

        }

        @GetMapping("/deleteEmployee")
        public String deleteEmployee(@RequestParam Integer employeeId){
            employeeService.deleteEmployeeById(employeeId);
            return "redirect:/list";
        }

}
