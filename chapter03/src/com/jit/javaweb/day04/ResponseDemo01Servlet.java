package com.jit.javaweb.day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp/text01")
public class ResponseDemo01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        resp.setStatus(302);
        //设置相应的头，且名称为location， 其另外一个为资源的访问路径
        resp.setHeader("location", "https://www.baidu.com");
//        resp.setHeader("location", "../../web/index.jsp");
    }
}
