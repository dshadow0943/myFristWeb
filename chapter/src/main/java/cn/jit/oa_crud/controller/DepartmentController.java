package cn.jit.oa_crud.controller;

import cn.jit.oa_crud.beans.Department;
import cn.jit.oa_crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService deptService;

    @RequestMapping(value = "/shows")
    public String getdepts(Map<String, Object> map){

//        List<Department> depts = deptService.findAllDepts();
//        for (Department e:depts){
//            System.out.println(e.toString());
//        }

        map.put("depts", deptService.findAllDepts());

        return "dept/shows";
    }

}
