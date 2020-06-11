package cn.jit.oa_crud.dao;

import cn.jit.oa_crud.beans.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentDao {

    //持久化一个部门信息
    public void save(Department dept);

    //查询所有部门信息
    public List<Department> findAll();

    //通过部门编号来查询一个部门信息
    public Department findById(String id);

    //
    public List<String> findAllDeptName();
}
