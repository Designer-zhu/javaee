package com.igeek.ch02.controller.servlet;

import com.igeek.ch02.entity.User;
import com.igeek.ch02.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码集
        //request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取免登录时长
        String selectValue = request.getParameter("select");


        if(username!=null && password!=null){
            UserService service = new UserService();
            User user = service.login(username, password);
            if(user != null){
                //检查身份审核状态
                String state = user.getState();
                switch (state){
                    case "0":
                        //登陆失败
                        request.setAttribute("mess","身份审核未通过");
                        request.getRequestDispatcher("fail.jsp").forward(request,response);
                        break;
                    case "1":
                        //登陆成功
                        //免登录（Cookie）通过Cookie存储姓名和密码
                        if(selectValue!=null && !selectValue.equals("0")){
                            int timeLength = Integer.parseInt(selectValue);
                            //1.创建Cookie
                            Cookie usernameCookie = new Cookie("usernameCookie", username);
                            Cookie passwordCookie = new Cookie("passwordCookie", password);
                            //2.设置Cookie存储的有效时间
                            usernameCookie.setMaxAge(timeLength*24*60*60);
                            passwordCookie.setMaxAge(timeLength*24*60*60);
                            //3.响应至客户端浏览器
                            response.addCookie(usernameCookie);
                            response.addCookie(passwordCookie);
                        }
                        request.getRequestDispatcher("success.jsp").forward(request,response);
                        break;
                    case "2":
                        //登陆失败
                        request.setAttribute("mess","当前账户审核失败，请重新提交信息");
                        request.getRequestDispatcher("fail.jsp").forward(request,response);
                        break;
                }


            }else {
                //登陆失败
                request.setAttribute("mess","没有此用户");
                request.getRequestDispatcher("fail.jsp").forward(request,response);
            }
        }else {
            //登陆失败
            //请求属性
            request.setAttribute("mess","用户名或密码为空");
            request.getRequestDispatcher("fail.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
