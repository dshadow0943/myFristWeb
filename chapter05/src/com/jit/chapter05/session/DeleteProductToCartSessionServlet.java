package com.jit.chapter05.session;

import com.jit.chapter05.dao.ProductDao;
import com.jit.chapter05.daomain.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cookie/delete")
public class DeleteProductToCartSessionServlet extends HttpServlet {
    ProductDao pdao = new ProductDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pid = req.getParameter("itemId");

        HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null){
            cart.removeCart(pid);
        } else if (cart.getItems() == null){
            session.removeAttribute("cart");
        }else {
            session.setAttribute("cart", cart);
        }
        System.out.println(cart.getItems().size());
        resp.sendRedirect(req.getContextPath()+"/cookie/showMyCart");
    }
}
