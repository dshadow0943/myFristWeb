package cn.jit.oa_crud.dao;


import cn.jit.oa_crud.beans.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface EmployeeDao {

    //添加员工信息
    public void save(Employee emp);

    //查询所有员工信息
    public List<Employee> findAll();

    //查询员工信息
    public Employee findById(String id);

    //根据员工id查询员工信息
    public void deleteById(String id);

    //查询所有员工的部门id
    public List<String> findDept_idAll();

    //根据员工id查询该员工所在部门的id
    public String findDept_idById(String id);

    //更该员工数据
    public void update(Employee mep);
}
