package com.jit.manager.daomain;

import java.util.List;

public class Department {
    private String id;
    private String name;
    private List<Employee> emps;

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(String id, String name, List<Employee> emps) {
        this.id = id;
        this.name = name;
        this.emps = emps;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
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
}
