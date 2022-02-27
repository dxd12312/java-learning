package servlet;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    获取请求参数，文件名称
        String filename = req.getParameter("filename");
    //    2.字节输入流加载文件到内存
    //    2.1找到文件的服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/images/" + filename);
    //    2.2直接流输入

        InputStream is = new FileInputStream(realPath);


    //    3.设置响应头的打开方式
        resp.setHeader("content-disposition","attachment;filename" + filename);

    //4.输入流写进输出流

        ServletOutputStream sos = resp.getOutputStream();
    //    缓冲区
        byte[] buff = new byte[1024*8];
        int len;
        while ((len = is.read(buff)) != -1) {
            sos.write(buff,0,len);
        }
        sos.close();
        is.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
