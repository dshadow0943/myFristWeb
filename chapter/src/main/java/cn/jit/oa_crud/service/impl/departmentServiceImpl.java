package cn.jit.oa_crud.service.impl;

import cn.jit.oa_crud.beans.Department;
import cn.jit.oa_crud.dao.DepartmentDao;
import cn.jit.oa_crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class departmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao deptDao;


    @Override
    public void saveDept(Department dept) {
        deptDao.save(dept);
    }

    @Override
    public List<Department> findAllDepts() {
        return deptDao.findAll();
    }

    @Override
    public Department findByIdDept(String id) {
        return deptDao.findById(id);
    }
}
