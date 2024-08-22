package com.ra.session01.controller;

import com.ra.session01.model.entity.Employee;
import com.ra.session01.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employeeList";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeAdd";
    }
    @PostMapping("/add")
    public String doAdd( @ModelAttribute Employee employee, Model model) {
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employee/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employeeEdit";
    }
    @PostMapping("/edit")
    public String doEdit(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
    @PostMapping("/search")
    public String search(Model model,@RequestParam(name = "search") String search ) {
        model.addAttribute("employees",employeeService.search(search));
        return "employeeList";
    }
}
