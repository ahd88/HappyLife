package com.happylife.controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/*
 * public class MyWebAppInitializer implements WebApplicationInitializer {
 * 
 * @Override public void onStartup(ServletContext container) {
 * XmlWebApplicationContext appContext = new XmlWebApplicationContext();
 * appContext.setConfigLocation("/WEB-INF/config/dispatcher-config.xml");
 * 
 * ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",
 * new DispatcherServlet(appContext)); dispatcher.setLoadOnStartup(1);
 * dispatcher.addMapping("/img"); } }
 */