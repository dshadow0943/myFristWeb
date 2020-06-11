package cn.jit.oa_crud.beans;

import java.util.Date;

public class Employee {
    private String id;
    private String name;
    private boolean gender;
    private Date hireDate;//入职日期
    private int salary;//员工工资
    private String deptId;//表示员工所在的部门编号
    private Department dept;//表示该员工所属的部门

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Employee(String id, String name, boolean gender, Date hireDate, int salary, Department dept) {

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.hireDate = hireDate;
        this.salary = salary;
        this.deptId = dept.getId();
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", deptId='" + deptId + '\'' +
                ", dept=" + dept +

                '}';
    }
}
