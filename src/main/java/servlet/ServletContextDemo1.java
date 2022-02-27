package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = "/path")
public class ServletContextDemo1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.得到ServletContext对象
        ServletContext context = this.getServletContext();
    //    2.web目录资源访问
        String bPath = context.getRealPath("/b.txt");
        System.out.println(bPath);
    //  3.  web-inf目录资源访问
        String cPath = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(cPath);
    //    4.src目录或子目录资源访问
        String aPath = context.getRealPath("/WEB-INF/classes/servlet/a.txt");
        System.out.println(aPath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
