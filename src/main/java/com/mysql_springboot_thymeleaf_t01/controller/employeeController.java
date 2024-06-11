package com.mysql_springboot_thymeleaf_t01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.mysql_springboot_thymeleaf_t01.entity.Employee;
import com.mysql_springboot_thymeleaf_t01.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class employeeController {
    
    @Autowired
    private EmployeeRepository eRepo;

    @GetMapping({"/showEmployees", "/", "/list"})
    public ModelAndView showEmployees() {
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> list = eRepo.findAll();
        mav.addObject("employees", list);
        return mav;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee newEmployee = new Employee();
        mav.addObject("employee", newEmployee);
        return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        eRepo.save(employee);
        return "redirect:/list";
    }

    @GetMapping({"/showUpdateForm"})
    public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee employee = eRepo.findById(employeeId).get();
        mav.addObject("employee", employee);
        return mav;
    }

    @GetMapping({"/deleteEmployee"})
    public String deleteEmployee(@RequestParam Long employeeId) {
        eRepo.deleteById(employeeId);
        return "redirect:/list";
    }
    
}
