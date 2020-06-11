package com.jit.javaweb.day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp/text03")
public class ResponseDemo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向客户端输出一些中文内容
//        resp.setContentType("text/html;charset=utf-8");
        //设置相应的编码相应的头信息参数
        resp.setCharacterEncoding("utf-8");
        //设置头信息名称
        resp.setHeader("Content-Type", "text/html");
        PrintWriter out = resp.getWriter();
        out.println("大家好，今天我很不高兴");
    }
}
