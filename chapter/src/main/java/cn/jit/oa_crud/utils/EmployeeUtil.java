package cn.jit.oa_crud.utils;

import cn.jit.oa_crud.beans.Department;
import cn.jit.oa_crud.beans.Employee;
import cn.jit.oa_crud.service.DepartmentService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeUtil {

    public Employee margeEmployee(HttpServletRequest request, DepartmentService deptService){
        Employee emp = new Employee();
        emp.setId(request.getParameter("id"));
        emp.setName(request.getParameter("name"));
        emp.setGender(Boolean.parseBoolean(request.getParameter("sex")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            emp.setHireDate(sdf.parse(request.getParameter("hireDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        emp.setSalary(Integer.parseInt(request.getParameter("salary")));
        String deptId = request.getParameter("dept.id");
        Department dept = deptService.findByIdDept(deptId);
        emp.setDept(dept);
        return emp;
    }

    /**
     * 填充部门信息
     * @param emps
     * @return
     */
    public List<Employee> perfect(List<Employee> emps, DepartmentService deptService){
        for (Employee e:emps){
            e.setDept(deptService.findByIdDept(e.getDeptId()));
        }
        return emps;
    }

    /**
     * 对提交表单进行验证
     * @param request
     * @return
     */
    public Map<String, String> validate(HttpServletRequest request){
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
