package com.jit.javaweb.day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(value = "/download")
public class ContextDownLoadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //为了实现当我们点击下载是显示一个下载的对话框
        String fileName = "web第1次实验.docx";
        resp.setHeader("Content-Disposition", "attachment;filename="+fileName);
        //获取对应的filename
        String realpath = this.getServletContext().getRealPath("/downloads/"+fileName);

        //获取该资源路劲对应的一个输入流对象
        InputStream fin = this.getServletContext().getResourceAsStream("/downloads/"+fileName);
        //从该输入流读取数据
        byte[] buff = new byte[1024];
        int len = -1;
        OutputStream out = resp.getOutputStream();

        while ((len = fin.read(buff)) > 0 ){
            out.write(buff, 0, len);
        }
        fin.close();
        out.close();
    }
}
