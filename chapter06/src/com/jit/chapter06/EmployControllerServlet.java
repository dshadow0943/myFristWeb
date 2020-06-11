package com.jit.chapter06;

import com.jit.manager.daomain.Department;
import com.jit.manager.daomain.Employee;
import com.jit.manager.service.EmployeeManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/emp/*")
public class EmployControllerServlet extends HttpServlet {

    private EmployeeManagerService empService = new EmployeeManagerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setCharacterEncoding("utf-8");
        if (uri.endsWith("/shows")){
            List<Employee> emps = empService.selectAllEmps();
            req.setAttribute("emps", emps);
            req.getRequestDispatcher("/WEB-INF/emp/emps.jsp").forward(req, resp);
            return;
        }else if (uri.endsWith("/add")){
            //分析请求的方式，如果是get方式表明是通过添加员工的超链接过来的，如果是post方式表明是要进行添加员工的表单提交
            String method = req.getMethod();
            System.out.println(method);
            if (method.equalsIgnoreCase("GET")){
                //显示员工添加页面
                //
                List<Department> depts = empService.selectAllDepts();
                req.setAttribute("depts", depts);
                req.getRequestDispatcher("/WEB-INF/emp/add.jsp").forward(req,resp);
            }else if (method.equalsIgnoreCase("POST")){
                //处理表单提交功能
                //验证数据合法性

                Map<String, String> errors = validate(req);
                if (errors != null && errors.size()>0){
                    req.setAttribute("errors", errors);
                    req.getRequestDispatcher("/WEB-INF/emp/add.jsp").forward(req, resp);
                    return;
                }
                //表示校验成功
                Employee emp = new Employee();
                emp.setId(req.getParameter("id"));
                emp.setName(req.getParameter("name"));
                emp.setSex(Boolean.parseBoolean(req.getParameter("sex")));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    emp.setHireDate(sdf.parse(req.getParameter("hireDate")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                emp.setSalary(Integer.parseInt(req.getParameter("salary")));
                String deptId = req.getParameter("dept.id");
                Department dept = empService.selectDeptById(deptId);
                emp.setDept(dept);

                empService.registerEmp(emp);
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
                return;

            }
        }else if (uri.endsWith("/update")){

            String method = req.getMethod();
            if (method.equalsIgnoreCase("GET")){
                String empId = req.getParameter("id");
                Employee emp = empService.selectEmpById(empId);
                req.setAttribute("emp", emp);
                req.setAttribute("depts", empService.selectAllDepts());
                req.getRequestDispatcher("/WEB-INF/emp/update.jsp").forward(req, resp);
                return;
            }else if (method.equalsIgnoreCase("POST")){
                Employee emp = new Employee();
                emp.setId(req.getParameter("id"));
                emp.setName(req.getParameter("name"));
                emp.setSex(Boolean.parseBoolean(req.getParameter("sex")));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    emp.setHireDate(sdf.parse(req.getParameter("hireDate")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                emp.setSalary(Integer.parseInt(req.getParameter("salary")));
                String deptId = req.getParameter("dept.id");
                Department dept = empService.selectDeptById(deptId);
                emp.setDept(dept);
                empService.updataEmp(emp);

                resp.sendRedirect(req.getContextPath()+"/index.jsp");
                return;

            }
        }else if (uri.endsWith("/delete")){
            String empId = req.getParameter("id");
            if (empId!=null){
                empService.deleteEmpById(empId);
            }
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }

    }

    /**
     * 对提交表单进行验证
     * @param request
     * @return
     */
    private Map<String, String> validate(HttpServletRequest request){
        Map<String, String> errors = new HashMap<String, String>();
        String id = request.getParameter("id");
        if (id == null || id.trim().isEmpty()){
            errors.put("id", "员工编号不能为空");
        }
        String name = request.getParameter("name");
        if (name== null || name.trim().isEmpty()){
            errors.put("name", "员工姓名不能为空");
        }
        String hirDate = request.getParameter("hireDate");
        if (hirDate == null || hirDate.trim().isEmpty()){
            errors.put("hirDate", "员工入职日期不能为空");
        }else {
            //校验格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                sdf.parse(hirDate);
            } catch (ParseException e) {
                errors.put("hirDate", "员工入职日期格式错误");
            }
        }
        String salary = request.getParameter("salary");
        if (salary == null || salary.trim().isEmpty()){
            errors.put("salary", "员工工资不能为空");
        }else {
            try{
                int money = Integer.parseInt(salary);
            }catch (NumberFormatException e){
                errors.put("salary", "员工工资输入有误");
            }
        }
        return errors;
    }
}
