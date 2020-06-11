package com.jit.chapter05.session;

import com.jit.chapter05.daomain.Item;
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

@WebServlet("/cookie/showMyCart")
public class ShowMyCartSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        DecimalFormat df = new DecimalFormat("###.00");

        HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        out.println("<br><br><h1>我的购物车</h1>");
        out.println("<table border = '1' width = '65%' align = 'center'>");
        out.println("<tr><th>条目编号</th><th>商品名称</th><th>商品价格</th><th>商品数量</th><th>条目总金额</th></tr>");
        if (cart != null && cart.getItems().size()>0){
            for (Item item:cart.getItems()){
                out.println("<tr>");
                out.println("<td>"+item.getId()+"</td>");
                out.println("<td>"+item.getProduct().getName()+"</td>");
                out.println("<td>"+item.getProduct().getPrice()+"</td>");
                out.println("<td>"+item.getNumber()+"</td>");
                out.println("<td>"+df.format(item.getSunMoney())+"</td>");
                out.println("<td><a href = '"+req.getContextPath()+"/cookie/delete?itemId="+item.getId()+"'>移除</td>");
                out.println("</tr>");
            }
            out.println("<tr><td colspan = '5' align = 'right'>"+df.format(cart.getTotalSumMoney())+"</td> </tr>");
        }else {
            out.println("<tr><td colspan = '6' align = 'right'>你的购物车为空, <a href = '/chapter05_war_exploded/cookie/shows'>前去购物></a></td> </tr>");
        }

        out.println("</table>");

        out.println("<h3><a href = '"+req.getContextPath()+"/cookie/shows'>继续购物</a>&nbsp;&nbsp;<a href=''>结账</a></h3>");
    }
}
