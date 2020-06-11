package com.jit.javaweb.day2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWordServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应头信息（也就是告诉浏览器服务器发送过来的数据类型及采用的编码）
        response.setContentType("text/html;charset=utf-8");
        //获取一个向客户端输出的流对象
        PrintWriter out = response.getWriter();
        //向客户端输出一条语句
        out.println("HelloWordServlet中的HelloWord Servle！");
    }
}
