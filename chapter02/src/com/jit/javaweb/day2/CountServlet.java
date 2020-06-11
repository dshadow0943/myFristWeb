package com.jit.javaweb.day2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/count")
public class CountServlet implements Servlet {
    int count;//统计页面被访问的次数
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("--初始化--");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("--getServletConfig--");
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("--服务请求方法--");
        count++;
        //设置相应的头信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>当前页面被访问了<font color='red'>["+count+"]</font>次了</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("--销毁--");
    }
}
