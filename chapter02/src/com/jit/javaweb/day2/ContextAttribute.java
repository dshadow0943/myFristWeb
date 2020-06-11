package com.jit.javaweb.day2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ServletContext作为域对象使用
 *
 * @author User
 * 删除： removeAttribut（"变量名"）
 * 该上下文域中储存的值对于该web应用的所有资源都可用
 */

@WebServlet(value = "/contextAttribute")
public class ContextAttribute extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ServletContext context = this.getServletContext();
        Integer num = (Integer) context.getAttribute("count");
        if (num == null || num == 0){
            context.setAttribute("count", 1);
        }else {
            context.setAttribute("count", ++num);
        }
        int count = (Integer) context.getAttribute("count");
        out.println("<h1>当前的Servlet被访问了[" + count + "]次");
    }
}
