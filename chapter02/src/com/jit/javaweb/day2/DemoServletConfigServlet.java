package com.jit.javaweb.day2;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DemoServletConfigServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ServletConfig config = this.getServletConfig();
        String userName = config.getInitParameter("user");
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            String value = config.getInitParameter(name);
            out.println(name+":"+value+"<br>");
        }
    }
}
