package com.jit.javaweb.day2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/realPath")
public class ContextSourceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        ServletContext context = this.getServletContext();
        String parentPath = context.getRealPath("/downloads");
        out.println("ServletContext.getRealPath(/downloads)"+parentPath);
        File parentFile = new File(parentPath);
        //遍历文件夹
        File[] files = parentFile.listFiles();
        out.println("<br><Hr><br>服务器可供下载资源如下： <br>"+ files.length+ "<br>");
        for (File f:files){
            System.out.println("-----------");
            String fileName = f.getName();
            out.println(fileName + "-----<br>");
        }
    }
}
