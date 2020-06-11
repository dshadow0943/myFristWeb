package com.jit.manager.service;

import com.jit.manager.dao.DepartmentDao;
import com.jit.manager.dao.EmployeeDao;
import com.jit.manager.dao.impl.DepartmentDaoImpl;
import com.jit.manager.dao.impl.EmployeeDaoImpl;
import com.jit.manager.daomain.Department;
import com.jit.manager.daomain.Employee;

import java.util.List;

public class EmployeeManagerService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    /**
     * 注册一个新员工
     * @param emp
     */
    public void registerEmp(Employee emp){
        employeeDao.add(emp);
    }

    public List<Employee> selectAllEmps(){
        return employeeDao.findAll();
    }

    public List<Department> selectAllDepts(){
        return departmentDao.findAll();
    }

    public void updataEmp(Employee emp){
        employeeDao.upppdate(emp);
    }

    public Employee selectEmpById(String id){
        return employeeDao.findById(id);
    }

    public Department selectDeptById(String id){
        return departmentDao.findById(id);
    }

    public void deleteEmpById(String id){
        employeeDao.deleteById(id);
    }




}
