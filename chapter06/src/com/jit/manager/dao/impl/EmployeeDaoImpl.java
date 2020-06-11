package com.jit.manager.dao.impl;

import com.jit.manager.dao.EmployeeDao;
import com.jit.manager.daomain.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static List<Employee> emps = new ArrayList<Employee>();

    @Override
    public void add(Employee emp) {
        emps.add(emp);
    }

    @Override
    public Employee findById(String id) {
        Employee emp = null;
        for (Employee e:emps){
            if (e.getId().equals(id)){
                emp = e;
                break;
            }
        }
        return emp;
    }

    @Override
    public List<Employee> findAll() {
        return emps;
    }

    @Override
    public void upppdate(Employee emp) {
        int i = 0;
        for (Employee e:emps){
            if (e.getId().equals(emp.getId())){
                emps.remove(e);
                emps.add(i, emp);
                break;
            }
            i++;
        }
    }

    @Override
    public void deleteById(String id) {
        for (Employee e:emps){
            if (e.getId().equals(id)){
                emps.remove(e);
                break;
            }
        }
    }
}
