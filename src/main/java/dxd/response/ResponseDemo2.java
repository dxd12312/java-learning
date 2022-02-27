package dxd.response;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ResponseDemo2 被访问....");
    //////    1.设置状态吗302：重定向
    ////    resp.setStatus(302);
    //////    2.设置响应头
    ////    resp.setHeader("location","/day03/response");
    ////
    ////    resp.setHeader("dxd","hello response");
    ////    req.setAttribute("dxd","hello response");
    ////    req.getRequestDispatcher("responseDemo2").forward(req,resp);
    //    Object dxd = req.getAttribute("dxd");
    //    System.out.println(dxd);
        ServletContext context = req.getServletContext();
        Object data = context.getAttribute("data");
        System.out.println( data);

    }
}
