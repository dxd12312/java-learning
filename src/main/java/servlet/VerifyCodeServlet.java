package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@WebServlet("/code")
public class VerifyCodeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //    定义验证码大小
        int width = 120;
        int height = 45;
    //    创建一共在内存中存放验证码图片的对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    //    绘制图片
    //    画笔对象
        Graphics g =image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);

    //    绘制边框
        g.setColor(Color.BLACK);
        g.drawRect(0,0,-1,-1);

        String str = "ABCDEFGHJKLI1234567890";
        str.getBytes(StandardCharsets.UTF_8);

    //    随机生成下标
        Random random = new Random();


    //    四位验证码
        for (int i =1; i<=4;i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(String.valueOf(ch),width/6 + 18*(i+1),height/2);


        //    todo:绘制干扰线
            g.setColor(Color.RED);
            for (i = 0; i <10; i++){
                int x1 = random.nextInt(width);
                int y1 = random.nextInt(height);

                int x2 = random.nextInt(width);
                int y2 = random.nextInt(height);

                g.drawLine(x1,y1,x2,y2);
            }

        //    验证码输出页面
            ImageIO.write(image,"jpg",resp.getOutputStream());
        }

    }
}
