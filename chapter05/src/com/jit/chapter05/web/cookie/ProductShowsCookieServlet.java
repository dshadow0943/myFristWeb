package com.jit.chapter05.web.cookie;

import com.jit.chapter05.dao.ProductDao;
import com.jit.chapter05.daomain.Product;
import com.jit.chapter05.daomain.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

    @WebServlet("/cookie/shows")
public class ProductShowsCookieServlet extends HttpServlet {
    private ProductDao productDao = new ProductDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        DecimalFormat df = new DecimalFormat("###.00");

        List<Product> list = productDao.findAll();
        out.println("<br><br><center>");
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") != null){
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            out.println("<a href = "+req.getContextPath()+"/cookie/showMyCart>我的购物车["+cart.getItems().size()+"] </a>");
        }else {
            out.println("<a href = "+req.getContextPath()+"/cookie/showMyCart>我的购物车[0] </a>");
        }
        out.println("<table border='1' width='75%'>");
        out.println("<tr><th>商品编号</th><th>商品名称</th><th>商品价格</th><th>商品描述</th><th>商品详情</th></tr>");
        for (Product p:list){
            out.println("<tr>");
            out.println("<td>"+p.getId()+"</td>");
            out.println("<td>"+p.getName()+"</td>");
            out.println("<td>"+df.format(p.getPrice())+"</td>");
            out.println("<td>"+p.getDesc()+"</td>");
            out.println("<td><a href='"+req.getContextPath()+"/cookie/findProduct?id="+p.getId()+"'>查看详情</a></td>");
            out.println("<td><a href='"+req.getContextPath()+"/session/addCart?pid="+p.getId()+"'>加入购物车</a></td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</center>");
    }
}
