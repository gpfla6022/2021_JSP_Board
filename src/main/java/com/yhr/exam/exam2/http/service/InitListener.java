package com.yhr.exam.exam2.http.service;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yhr.exam.exam2.app.App;


@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	App.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}