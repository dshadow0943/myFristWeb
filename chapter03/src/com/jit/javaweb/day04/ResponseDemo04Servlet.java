package com.jit.javaweb.day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/resp/text04")
public class ResponseDemo04Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().println("5秒后跳转到新浪");
//        resp.setHeader("Refresh", "5;URL=https://www.sina.com.cn");
        resp.setHeader("Refresh", "1");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = sdf.format(new Date());
        resp.getWriter().println("<h1>当前系统时间为："+currentTime+"</h1>");
    }
}
