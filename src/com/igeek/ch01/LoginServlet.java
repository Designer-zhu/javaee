package com.igeek.ch01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    public LoginServlet(){
        System.out.println("Login");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码集
        request.setCharacterEncoding("utf-8");
        //设置响应编码集
        response.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username != null && !"".equals(password)){
            //跳转至成功界面
            //响应重定向：会产生新的请求，不会携带数据
            //response.sendRedirect("success");

            //请求转发:不会产生新的数据，沿用之前的请求，所以可以携带数据
            request.getRequestDispatcher("success").forward(request,response);

        }else {
            //跳转至失败界面
            //响应重定向：会产生新的请求，不会携带数据
            response.sendRedirect("fail");
            //request.getRequestDispatcher("fail").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
