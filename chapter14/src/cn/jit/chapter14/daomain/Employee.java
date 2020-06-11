package cn.jit.chapter14.daomain;

import java.util.Date;

public class Employee {
    private String id; //用户编号
    private String name; //用户姓名
    private Boolean sex; //性别
    private Date hireDate; //入职日期
    private Integer salary; //工资

    public Employee() {
    }

    public Employee(String id, String name, Boolean sex, Date hireDate, Integer salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.hireDate = hireDate;
        this.salary = salary;
    }

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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", hirDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
