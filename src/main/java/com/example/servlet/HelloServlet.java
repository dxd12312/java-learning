package com.example.servlet;

import java.awt.*;
import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        System.out.println("init...");
        message = "谷爱凌夺金";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String json = "{\"name\": \"ABC\",\n" +
                "   \"age\": \"22\"}";
        out.println(json);
        out.flush();
        out.close();
        //System.out.println("get请求");
        //
        //// Hello
        //PrintWriter out = response.getWriter();
        //out.println("<html><body>");
        //out.println("<h1>" + message + "</h1>");
        //out.println(="images/bdd.jpg");
        //out.println("</body></html>");

    }

    public void destroy() {
        System.out.println("destroyed...");
    }
}