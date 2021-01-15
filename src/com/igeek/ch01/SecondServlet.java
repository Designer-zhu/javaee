package com.igeek.ch01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SecondServlet",urlPatterns = "/second"
        ,initParams = {@WebInitParam(name="version",value = "1.0")}
        /*,loadOnStartup = 1*/)
public class SecondServlet extends HttpServlet {

    //实例化
    public SecondServlet(){
        System.out.println("实例化");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化");
        String version = config.getInitParameter("version");
        System.out.println("version = "+version);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
    }
}
