package com.nju.mycrowedfunding.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerStartupListener implements ServletContextListener {
    //在web应用对象初始化的时候的监听器，用来将web应用名称保存到应用范围的APP_PATH变量中
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        String path = application.getContextPath();
        application.setAttribute("APP_PATH",path);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
