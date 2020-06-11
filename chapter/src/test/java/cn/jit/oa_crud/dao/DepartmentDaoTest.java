package cn.jit.oa_crud.dao;

import cn.jit.oa_crud.beans.Department;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class DepartmentDaoTest {

    private ApplicationContext applicationContext;

    @Autowired
    private DepartmentDao mapper;

    @Before
    public void setUp() throws Exception {
        // 加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        // 导入需要测试的
        mapper = applicationContext.getBean(DepartmentDao.class);
    }

    @Test
    void save() {

    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
        Department emp = mapper.findById("00001");
        System.out.println(emp);
    }
}