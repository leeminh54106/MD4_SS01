package com.ra.session01.service;

import com.ra.session01.model.entity.Employee;
import com.ra.session01.repository.IEmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepo employeeRepo;
    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> search(String keyword) {
        return employeeRepo.search(keyword);
    }
}
