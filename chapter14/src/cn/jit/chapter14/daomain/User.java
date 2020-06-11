package cn.jit.chapter14.daomain;

import java.util.Date;

//用户实体类
public class User {
    private Integer id; //用户编号
    private String name; //用户姓名
    private Boolean gender; //性别
    private Date birthday; //出生日期
    private String mobile; //联系电话


    public User() {

    }

    public User(Integer id, String name, Boolean gender, Date birthday, String mobile) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
