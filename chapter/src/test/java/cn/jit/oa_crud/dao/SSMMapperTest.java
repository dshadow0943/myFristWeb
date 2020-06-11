package cn.jit.oa_crud.dao;
import cn.jit.oa_crud.beans.Department;
import cn.jit.oa_crud.beans.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;
//@RunWith(value = SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:spring.xml"})
public class SSMMapperTest {
    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testBatch() {
//        for(int i=1;i<=2000;i++) {
//            String id=""+(10000+i);
//            String name= UUID.randomUUID().toString().substring(0,5);
//            boolean gender=(int)(Math.random())==0?true:false;
//            Date hireDate=new Date();
//            int salary=(int)(Math.random()*20000);
//            int n=(int)(Math.random()*5)+1;
//            String dept_id="";
//            switch(n) {
//                case 1:dept_id="11111";break;
//                case 2:dept_id="22222";break;
//                case 3:dept_id="33333";break;
//                case 4:dept_id="44444";break;
//                default:dept_id="55555";
//
//            }
//            Department dept=new Department(dept_id);
//            Employee emp=new Employee(id,name,gender,hireDate,salary,dept);
//            EmployeeDao empDao = sqlSession.getMapper(EmployeeDao.class);
//            empDao.save(emp);
//        }
    }
}

