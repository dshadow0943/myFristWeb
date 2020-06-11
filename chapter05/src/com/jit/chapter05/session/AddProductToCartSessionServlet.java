package com.jit.chapter05.session;

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

@WebServlet("/session/addCart")
public class AddProductToCartSessionServlet extends HttpServlet {

    ProductDao pdao = new ProductDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        Product product = pdao.findById(pid);

        HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null){
            cart = new ShoppingCart();
        }
        cart.addCart(product);
        session.setAttribute("cart", cart);

        resp.sendRedirect(req.getContextPath()+"/cookie/findProduct?id="+pid);
    }
}
