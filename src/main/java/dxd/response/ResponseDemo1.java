package dxd.response;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/responseDemo1")
public class ResponseDemo1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    System.out.println("ResponseDemo1....");
    ////    1.设置状态吗302：重定向
    //    resp.setStatus(302);
    ////    2.设置响应头
    //    resp.setHeader("location","https://www.baidu.com");
        resp.setHeader("refresh","3;responseDemo2");
        req.setAttribute("dxd","hello response");
        req.getRequestDispatcher("responseDemo2").forward(req,resp);
    }
}
