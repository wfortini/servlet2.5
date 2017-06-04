package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.model.Usuario;

public class MyServletContextListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		ServletContext ctx = arg0.getServletContext();
		
		String nome = ctx.getInitParameter("nome");
		String email = ctx.getInitParameter("email");
		
		Usuario usuario = new Usuario(nome, email);
		
		ctx.setAttribute("usuario", usuario);
		
		System.out.println("ServletContextListener ============================  App iniciou ");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener ============================  App parou");
		
	}

}
