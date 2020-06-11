package cn.jit.chapter14.dao;

import cn.jit.chapter14.daomain.User;

import java.util.List;

public interface UserDao {

    //持久化一个用户数据
    public void save(User user);

    //通过用户编号来查询对象信息
    public User findById(int id);

    //查询所有的用户信息
    public List<User> findAll();

    //通过用户名和性别来查询用户信息
    public List<User> findByNameAndGender(String name, Boolean gender);

    //修改一个用户信息
    public void update(User user);

    //通过用户编号来删除一个用户信息
    public void deleteById(int id);

}
