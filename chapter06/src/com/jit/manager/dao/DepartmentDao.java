package com.jit.manager.dao;

import com.jit.manager.daomain.Department;

import java.util.List;

public interface DepartmentDao {
    public List<Department> findAll();

    public Department findById(String id);
}
