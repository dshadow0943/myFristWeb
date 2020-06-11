package com.jit.manager.dao.impl;

import com.jit.manager.dao.DepartmentDao;
import com.jit.manager.daomain.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static List<Department> depts = new ArrayList<Department>();
    static {

    }

    @Override
    public List<Department> findAll() {
        return depts;
    }

    @Override
    public Department findById(String id) {
        Department dept = null;
        for (Department d:depts){
            if (d.getId().equals(id)){
                dept = d;
                break;
            }
        }
        return dept;
    }
}
