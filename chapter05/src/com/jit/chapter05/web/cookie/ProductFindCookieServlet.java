package com.jit.chapter05.web.cookie;

import com.jit.chapter05.dao.ProductDao;
import com.jit.chapter05.daomain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
            out.println("<img src = '"+req.getContextPath()+"/images/"+p.getImagePath()+"' width='300px' height='150px' /><br>");
            out.println("商品编号: "+p.getId()+"  商品名称: "+p.getName()+ "</br>");
            out.println("商品价格: "+String.format("%.2f", p.getPrice())+"    商品描述: "+p.getDesc()+ "</br>");
            out.println("<br><a href='"+req.getContextPath()+"/session/addCart?pid="+p.getId()+"'>加入购物车</a>");

            updateCookie(req, resp, p);

        }
        out.println("<br><br><hr><br><h3><a href = '"+req.getContextPath()+"/cookie/shows'>回到商品显示首页</a></h3>");
    }

    /**
     * 更新Cookie
     * @param request
     * @param response
     * @param p
     */
    private void updateCookie(HttpServletRequest request, HttpServletResponse response, Product p){
        Cookie cookie = null;
        Cookie[] cs = request.getCookies();
        for (int i = 0; cs!=null && i<cs.length; i++) {
            if ("products".equals(cs[i].getName())) {
                cookie = cs[i];
                break;
            }
        }

        if (cookie == null){
            cookie = new Cookie("products", p.getId());
            cookie.setMaxAge(-1);  //在当前浏览器中有效
        }else {
            String[] array = cookie.getValue().split("-");
            if (array==null && array.length==1){
                if (!cookie.getValue().equals(p.getId())){
                    cookie.setValue(p.getId()+"-"+cookie.getValue());
                }
            }else {
                boolean b = false;
                for (int i = 0; i < array.length; i++) {
                    if (array[i].equals(p.getId())){
                        StringBuffer sb = new StringBuffer();
                        sb.append(p.getId()).append("-");
                        for (int j = 0; j < array.length; j++) {
                            if (j!=i){
                                sb.append(array[j]).append("-");
                            }
                        }
                        String line = sb.toString();
                        if (line.lastIndexOf("-") == line.length()-1){
                            line = line.substring(0, line.length()-1);
                        }

                        cookie.setValue(line);
                        b = true;
                        break;
                    }
                }
                if (!b){
                    if (array.length<5){
                        cookie.setValue(p.getId()+"-"+cookie.getValue());
                    }else {
                        cookie.setValue(p.getId()+"-"+cookie.getValue().substring(0, cookie.getValue().lastIndexOf("-")));
                    }
                }
            }
        }
        response.addCookie(cookie);
    }
}
