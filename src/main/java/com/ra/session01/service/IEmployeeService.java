package com.ra.session01.service;

import com.ra.session01.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    void save(Employee employee);
    void deleteById(Long id);
    List<Employee> search(String keyword);
}
