package com.jit.chapter05.web.cookie;

import com.jit.chapter05.dao.ProductDao;
import com.jit.chapter05.daomain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie/findProduct")
public class ProductFindCookieServlet extends HttpServlet {
    private ProductDao pdao = new ProductDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("id");
        Product p = pdao.findById(id);
        if (p != null){
            out.println("<img src = '/chapter05_war_exploded/images/"+p.getImagePath()+"' width='300px' height='150px' /><br>");
            out.println("商品编号: "+p.getId()+"  商品名称: "+p.getName()+ "</br>");
            out.println("商品价格: "+String.format("%.2f", p.getPrice())+"    商品描述: "+p.getDesc()+ "</br>");
            out.println("<br><a href='"+req.getContextPath()+"/session/addCart?pid="+p.getId()+"'>加入购物车</a>");
        }
        out.println("<br><br><hr><br><h3><a href = '"+req.getContextPath()+"/cookie/shows'>回到商品显示首页</a></h3>");
    }
}
