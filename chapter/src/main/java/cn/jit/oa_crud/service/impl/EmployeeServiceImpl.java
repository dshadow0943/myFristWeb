package cn.jit.oa_crud.service.impl;

import cn.jit.oa_crud.beans.Employee;
import cn.jit.oa_crud.dao.EmployeeDao;
import cn.jit.oa_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao empDao;

    @Override
    public void saveEmp(Employee emp) {
        empDao.save(emp);
    }

    @Override
    public List<Employee> findAllEmp() {
        return empDao.findAll();
    }

    @Override
    public Employee findByIdEmp(String id) {
        return empDao.findById(id);
    }

    @Override
    public void deleteByIdEmp(String id) {
        empDao.deleteById(id);
    }

    @Override
    public List<String> findDept_idAllEmp() {
        return empDao.findDept_idAll();
    }

    @Override
    public String findDept_idByIdEmp(String id) {
        return empDao.findDept_idById(id);
    }
}
