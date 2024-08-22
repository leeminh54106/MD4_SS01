package com.ra.session01.repository;

import com.ra.session01.model.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class EmployeeRepoImpl implements IEmployeeRepo {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Employee> findAll() {
        return em.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(Long id) {
        return em.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            em.persist(employee);
        }else{
            em.merge(employee);
        }
    }

    @Override
    public void deleteById(Long id) {
        em.remove(findById(id));
    }

    @Override
    public List<Employee> search(String keyword) {
        return em.createQuery("from Employee where fullName like :keyword or departmentName like :keyword",Employee.class).setParameter("keyword", "%" + keyword + "%").getResultList();
    }
}
