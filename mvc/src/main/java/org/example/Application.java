package org.example;

import org.example.WebConfig;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Application {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080); // Set the port number

        // Set your desired context path here
        String contextPath = "/myapp"; // Change this to your desired context path
        tomcat.addWebapp(contextPath, new File("src/main/java/org.example").getAbsolutePath());

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(context));

        // Start Tomcat
        tomcat.start();
        tomcat.getServer().await();
    }
}
