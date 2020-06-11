package cn.jit.oa_crud.controller;

import cn.jit.oa_crud.beans.Department;
import cn.jit.oa_crud.beans.Employee;
import cn.jit.oa_crud.service.DepartmentService;
import cn.jit.oa_crud.service.EmployeeService;
import cn.jit.oa_crud.utils.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @Autowired
    private DepartmentService deptService;

    private EmployeeUtil empUtil = new EmployeeUtil();

    @RequestMapping("/shows")
    public String getEmps(Map<String, Object> map){
        map.put("emps", empUtil.perfect(empService.findAllEmp(), deptService));
        return "emp/shows";
    }

    @RequestMapping("/add")
    public String AddEmp(HttpServletRequest request, Map<String, Object> map){
//        System.out.println("进入add");
        if (request.getMethod().equalsIgnoreCase("Get")){
//            System.out.println("get请求");
            map.put("depts", deptService.findAllDepts());
            return "emp/add";

        } else if (request.getMethod().equalsIgnoreCase("POST")){
//            System.out.println("pust请求");
            Map<String, String> errors = empUtil.validate(request);
            if (errors != null && errors.size()>0){
                request.setAttribute("errors", errors);
                return "emp/add";
            }
            //校验成功
            empService.saveEmp(empUtil.margeEmployee(request, deptService));
            map.put("emps", empUtil.perfect(empService.findAllEmp(), deptService));
            return "emp/shows";
        }
        return "emp/add";
    }

    @RequestMapping("/delete")
    public String deleteEmp(HttpServletRequest request, Map<String, Object> map){
        String id = request.getParameter("id");
        empService.deleteByIdEmp(id);
        map.put("emps", empUtil.perfect(empService.findAllEmp(), deptService));
        return "emp/shows";
    }

    @RequestMapping("/update")
    public String updateEmpById(HttpServletRequest request, Map<String, Object> map){
        if (request.getMethod().equalsIgnoreCase("GET")){
            String id = request.getParameter("id");
            Employee emp = empService.findByIdEmp(id);
            List<Department> depts = deptService.findAllDepts();
            map.put("emp", emp);
            map.put("depts", depts);
            return "emp/update";
        }else if(request.getMethod().equalsIgnoreCase("POST")){
            System.out.println("pust请求");
            Map<String, String> errors = empUtil.validate(request);
            if (errors != null && errors.size()>0){
                request.setAttribute("errors", errors);
                return "emp/update";
            }
            Employee emp = empUtil.margeEmployee(request, deptService);
            System.out.println(emp.toString());
            empService.updateEmp(empUtil.margeEmployee(request, deptService));
            System.out.println(emp.toString());
            map.put("emps", empUtil.perfect(empService.findAllEmp(), deptService));
            return "emp/shows";
        }
        return "emp/update";
    }

}
