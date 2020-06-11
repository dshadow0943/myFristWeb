package cn.jit.chapter14.daomain;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String id;//部门的编号
    private String name;//部门的名称
    private List<Employee> emps=new ArrayList<Employee>();//表示该部门下的所有员工
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Employee> getEmps() {
        return emps;
    }
    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }
    public Department() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Department(String id) {
        super();
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
