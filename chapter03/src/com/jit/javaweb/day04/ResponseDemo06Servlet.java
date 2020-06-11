package com.jit.javaweb.day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp/text06")
public class ResponseDemo06Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; cahrset=utf-8");
        String userName = req.getParameter("name");
        String userPwd = req.getParameter("pwd");
        if (userName.equals("scott")&&"tiger".equals(userPwd)){
            resp.getWriter().println("<font color = 'red' size = '35'>登录成功！</font>");
        }else {
            req.getServletContext().setAttribute("info", "用户名或密码错误，请重新登录！");
            resp.sendRedirect("/chapter03_war_exploded/table/index.jsp");
//            resp.setStatus(302);
//            resp.setHeader("location", "/chapter03_war_exploded/table/index.jsp");
        }

    }
}
