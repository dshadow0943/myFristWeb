package cn.jit.oa_crud.service;

import cn.jit.oa_crud.beans.Employee;
import org.w3c.dom.ls.LSException;

import java.util.List;

public interface EmployeeService {

    public void saveEmp(Employee emp);

    public List<Employee> findAllEmp();

    public Employee findByIdEmp(String id);

    public void deleteByIdEmp(String id);

    public List<String> findDept_idAllEmp();

    public String findDept_idByIdEmp(String id);

}
