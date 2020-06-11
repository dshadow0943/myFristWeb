package com.jit.javaweb.day02;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ServletConfig 可以用来获取该Servlet配置的初始化信息，在web.xml中可以通过使用
 *          init-param标签来给该Servlet配置初始化参数
 */
@WebServlet(urlPatterns = {"/day02/stuLogin", "/stuLogin"}, initParams = {@WebInitParam(name = "path", value = "E:\\log.text")})
public class StudentLoginServlet implements Servlet {

    //文件输出流对象
    PrintWriter fout = null;
    //文件输入流对象
    BufferedReader in = null;
    //因暂时没有绑定数据库，所以以一个Map映射储存学生信息
    HashMap stuMap;
    //保存已签到学生学号
    Set<String> stuIdSet = new HashSet<String>();
    //创建日志文件的文件名
    String filePath;
    //保存已签到学生的学号和ip地址，以映射关系联系起来
    HashMap stuIpMap = new HashMap();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //默认第一次访问该Servlet类时被执行
        //获取初始化的参数，该方法为init-parem标签指定的值
        stuMap = getMap();
        filePath = config.getInitParameter("path");
//        创建文件
        File file = new File(filePath);
//        把该文件绑定到文件的输出流对象fout
        try {
            fout = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //设置所采用的编码
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //获取客户端表单中的数据
        //获取学生id
        String stuId = request.getParameter("stuId");
        //获取学生姓名
        String name = request.getParameter("stuName");
        //获取客户端的IP地址
        String clientIp = request.getRemoteAddr();

        //以多重判断在客户端输出相应的信息
        if (stu(stuId, name) == true){          //判断填写的表格信息是否正确
            if (repeat(stuId) == true){         //判断是否重复签到
                if (replace(clientIp, stuId) == true){      //判断是否代签
                    out.println(name+"同学恭喜你签到成功<br>");
                    finish(stuId, name, clientIp, out);
                }else {
                    out.println("非常抱歉，签到失败");
                }
            }else {
                out.println("你已签到，请勿重复签到");
            }
        }else {
            out.println("抱歉，信息填写错误，签到失败，请重新填写信息");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        //用来释放资源，关闭文件
        if (fout != null){
            fout.close();
        }
    }

    /**
     * 初始化创建学生信息，因简单只有学号和姓名，便直接建立讲个数据间的映射关系
     * @return
     */
    private HashMap getMap(){
        HashMap stuMap = new HashMap();
        stuMap.put("000001", "张三");
        stuMap.put("000002", "李四");
        stuMap.put("000003", "王五");
        stuMap.put("000004", "小二");
        stuMap.put("000005", "熊大");
        return stuMap;
    }

    /**
     * 判断填写的表格信息是否正确,以学号和姓名是否对应做判断依据
     * @param stuId 学生学号
     * @param stuName 学生姓名
     * @return
     */
    private boolean stu(String stuId, String stuName){
        if (stuMap.get(stuId) != null && stuMap.get(stuId).equals(stuName)){
            return true;
        }
        return false;
    }

    /**
     * 判断是否代签
     * @param ip 学生客户端ip地址
     * @param id  学生学号
     * @return
     */
    private boolean replace(String ip, String id){
        if (stuIpMap.get(ip) == null){
            stuIpMap.put(ip, id);
            return true;
        }
        return false;
    }

    /**
     * 判断是否重复签到
     * @param id 学生学号
     * @return
     */
    private boolean repeat(String id){
        if (stuIdSet.contains(id) == false){
            stuIdSet.add(id);
            return true;
        }
        return false;
    }

    /**
     * 处理学生信息
     * @param stuId 学生学号
     * @param name  学生姓名
     * @param clientIp 学生客户端地址
     * @param out   文件输出流对象
     */
    private void finish(String stuId, String name, String clientIp, PrintWriter out){
        //获取签到的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String loginTime = sdf.format(new Date());
        //使用fout把用户登录信息记录到日志文件中
        if (fout != null){
            synchronized (this){  //因为servlet是单实例的，只会被创建一个
                fout.println(stuId + " " + name + " " + loginTime + " " + clientIp);
//                fout.println("学号是["+stuId+"], 姓名是["+name+"]的学生在["+loginTime+"]时间["+clientIp+"]上签到");
                fout.flush();//因为PrintWriter流是带缓冲的，所以得用flush来强制写入
            }
        }

        //从日志文件中读取以成功签到学生信息
        out.println("已签到学生如下：<br>");
        try {
            //实例化文件输入流对象
            in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            String line = in.readLine();
            while (line!= null){
                //再客户端打印签到信息
                out.println(line + "<br>");
                line = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
