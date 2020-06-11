package com.jit.javaweb.day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/resp/text05")
public class ResponseDemo05Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义要下载的文件名称
        String fileName = "新建文本文档.txt";
        //设置可下载的头信息参数
        resp.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode(fileName, "utf-8"));
        //获取向客户端输出的流对象
        OutputStream out = resp.getOutputStream();
        //吧要下载的文件包装成一个文件对象
        String realpath = this.getServletContext().getRealPath("/images");//返回该相对路径的绝对路径
        File file = new File(realpath, "新建文本文档.txt");
        if (file.exists()){
            FileInputStream fin = new FileInputStream(file);
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = fin.read(buff)) > 0){
                out.write(buff, 0, len);
            }
            out.flush();
            out.close();
        }
    }
}
