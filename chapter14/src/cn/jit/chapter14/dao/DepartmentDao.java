package cn.jit.chapter14.dao;


import cn.jit.chapter14.daomain.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;


public interface DepartmentDao {

    //持久化一个部门信息
    @Insert("insert into tb_dept(id, name) values(#{dept.id}, #{dept.name})")
    public void save(Department dept);

    //查询所有部门信息
    @Select("select * from tb_dept")
    @Results(value = {
            @Result(column = "id", property = "id", id = true, javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "name", javaType = String.class),
    })
    public List<Department> findAll();

    //通过部门编号来查询一个部门信息
    @Select("select * from tb_dept where id=#{id}")
    public Department findById(String id);
}
