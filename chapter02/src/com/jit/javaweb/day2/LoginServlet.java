package com.jit.javaweb.day2;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @WebServlet的使用
 *  属性：
 *  urlPatterns：用来设置对外的映射路径，作用和基于XML配置中的url-pattern作用类似
 */
@WebServlet(urlPatterns = {"/day02/login", "/login2"})
public class LoginServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //1.获取客户端表单中填写的登录数据，所有用户的消息都封装在了ServletRequest对象
        //通过request对象的getParameter(String name)方法来获取表单中的数据

        request.setCharacterEncoding("utf-8");
        //获取用户名称
        String name = request.getParameter("userName");
        String pwd = request.getParameter("password");
        //设置响应头消息
        response.setContentType("text/html;charset=utf-8");
        //获取一个向客户端输出的流对象
        PrintWriter out = response.getWriter();
        out.println("username:"+name+",password:"+pwd);
    }
}
