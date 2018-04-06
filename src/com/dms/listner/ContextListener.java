package com.dms.listner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

@WebListener("application context listener")
public class ContextListener implements ServletContextListener {

	  /**
     * Initialize log4j when the application is being started
     */
    public void contextInitialized(ServletContextEvent event) {
        // initialize log4j here
    	try {
    	ServletContext context = event.getServletContext();
        System.setProperty("logs", context.getRealPath("/logs"));
        Properties props = new Properties(); 
        String log4jConfigFile = context.getInitParameter("log4j-config-location");
        System.out.println("LogPath:"+context.getRealPath(log4jConfigFile));
        String fullPath = context.getRealPath(log4jConfigFile) ;
        props.put("logs", context.getRealPath("/logs")); 
        
			props.load(new FileInputStream(fullPath));
			PropertyConfigurator.configure(props);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // props.load(fullPath);
       // PropertyConfigurator.configure(fullPath);
      
    }
     
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    } 
	
}
