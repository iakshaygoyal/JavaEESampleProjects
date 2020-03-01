package com.akgoyal.customer.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
		ServletRegistration.Dynamic resgistration 
					= servletContext.addServlet("SpringDispatcher", dispatcherServlet);
		resgistration.setLoadOnStartup(1);
		resgistration.addMapping("/");
	}
	
}

