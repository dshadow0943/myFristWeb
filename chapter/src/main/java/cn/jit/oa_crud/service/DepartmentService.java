package cn.jit.oa_crud.service;

import cn.jit.oa_crud.beans.Department;

import java.util.List;

public interface DepartmentService {

    //持久化一个部门信息
    public void saveDept(Department dept);

    //查询所有部门信息
    public List<Department> findAllDepts();

    //通过部门编号来查询一个部门信息
    public Department findByIdDept(String id);

}
