package cn.jit.chapter14.dao;


import cn.jit.chapter14.daomain.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {

    @Insert(value = "insert into tb_employee(id, name, sex, hireDate, salary) values(#{id}, #{name}, #{sex}, #{hireDate}, #{salary})")
    public boolean save(Employee emp);

    @Select(value = "select * from tb_employee where id=#{id}")
    public Employee findById(String id);

    @Select("select * from tb_employee")
    @Results(value = {
            @Result(column = "id", property = "id", id = true, javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(column = "sex", property = "sex", javaType = Boolean.class, jdbcType = JdbcType.BOOLEAN),
            @Result(column = "hireDate", property = "hireDate", javaType = Date.class, jdbcType = JdbcType.DATE),
            @Result(column = "salary", property = "salary", javaType = int.class, jdbcType = JdbcType.INTEGER),
    })
    public List<Employee> findAll();

    @Select("select * from tb_employee where salary>=#{min} and salary<=#{max}")
    public List<Employee> findEmpsBySalary(@Param("min")int minSalary, @Param("max")int maxSalary);

    @Update(value = "update tb_employee set name = #{name}, sex = #{sex}, hireDate=#{hireDate}, salary=#{salary} where id = #{id}")
    public void updateEmp(Employee employee);

    @Delete(value = "delete from tb_employee where id = #{id}")
    public void deleteById(String id);
}
