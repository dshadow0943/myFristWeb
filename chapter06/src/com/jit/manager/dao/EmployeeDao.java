package com.jit.manager.dao;

import com.jit.manager.daomain.Employee;

import java.util.List;

//Dao层为持久化层（和数据打交道）
public interface EmployeeDao {
    public void add(Employee emp);

    public Employee findById(String id);

    public List<Employee> findAll();

    public void upppdate(Employee emp);

    public void deleteById(String id);
}
