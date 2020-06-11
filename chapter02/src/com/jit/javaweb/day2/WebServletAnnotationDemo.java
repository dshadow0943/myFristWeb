package com.jit.javaweb.day2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 注解@WebServlet()使用，
 * 该注解是加在servlet前面，属性如下
 * urlPatterns用来指定对外访问的映射路径，该参数是一个数组，可以把一个Servlet类映射成对外的不同访问路径，以“/”开头
 * value的作用和urlPatterns的作用相同，但只能使用一个
 * initParams用来为指定Servlet配置的初始化参数
 */
@WebServlet(urlPatterns = {"/webServlet", "/annotation"}, initParams = {@WebInitParam(name = "name", value = "张三")},
        name = "WebServletAnnotationDemo", loadOnStartup = 1)
public class WebServletAnnotationDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        ServletConfig config = this.getServletConfig();
        Enumeration<String> params = config.getInitParameterNames();
        while (params.hasMoreElements()){
            String name = params.nextElement();
            String value = config.getInitParameter(name);
            out.println(name+":"+value+"<br>");
        }
    }
}
