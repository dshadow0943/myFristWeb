package cn.jit.chapter14.test;

import cn.jit.chapter14.dao.EmployeeMapper;
import cn.jit.chapter14.daomain.Employee;
import cn.jit.chapter14.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class MyBatisForAnnotationTest {

    @Test
    public void testSave(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = new Employee("100000", "张三", true, new Date(), 6000);
        boolean result = mapper.save(emp);
        sqlSession.commit();
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    public void testSaves(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee[] emps = new Employee[5];
        for (int i = 0; i < 5; i++) {
            emps[i] = new Employee("10000"+(i+1), "姓名"+i, true, new Date(), 6000+i*400);
            boolean result = mapper.save(emps[i]);
            sqlSession.commit();
            System.out.println(result);
        }
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.findById("100001");
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = mapper.findAll();
        for (Employee emp:emps){
            System.out.println(emp);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectEmpsBySalary(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> emps = mapper.findEmpsBySalary(6500, 80000);
        for (Employee emp:emps){
            System.out.println(emp);
        }
        sqlSession.close();
    }

    @Test
    public void testempUpdate(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.findById("100001");
        System.out.println(emp);
        emp.setName("李四");
        emp.setSalary(7000);
        mapper.updateEmp(emp);
        emp = mapper.findById("100001");
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testempDelete(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = mapper.findById("100001");
        System.out.println(emp);
        mapper.deleteById("100001");
        emp = mapper.findById("100001");
        System.out.println(emp);
        sqlSession.close();
    }

}