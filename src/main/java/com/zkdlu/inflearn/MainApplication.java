package com.zkdlu.inflearn;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainApplication {
    public static void main(String[] args) {
        var applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(HelloApi.class);
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.refresh();

        var serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("dispatcherServlet",
                    new DispatcherServlet(applicationContext)
            ).addMapping("/*");
        });

        webServer.start();
    }
}
