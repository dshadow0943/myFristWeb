package cn.jit.chapter14.test;

import cn.jit.chapter14.dao.DepartmentDao;
import cn.jit.chapter14.dao.EmployeeMapper;
import cn.jit.chapter14.daomain.Department;
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
        Employee emp = new Employee("100001", "广发", true, new Date(), 6000);
        boolean result = mapper.save(emp);
        sqlSession.commit();
        System.out.println(result);
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
        List<Employee> emps = mapper.findEmpsBySalary(5000, 10000);
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
        emp.setSalary(8000);
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

    @Test
    public void testSelectDeptAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        List<Department> emps = mapper.findAll();
        for (Department emp:emps){
            System.out.println(emp.toString());
        }
        sqlSession.close();
    }

    @Test
    public void testSelectDeptById(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department dept = mapper.findById("00001");
        System.out.println(dept);

        List<Department> emps = mapper.findAll();
        for (Department emp:emps){
            System.out.println(emp.toString());
        }
        sqlSession.close();
    }

}
