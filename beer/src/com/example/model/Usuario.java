package com.example.model;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Usuario implements HttpSessionBindingListener, HttpSessionActivationListener{
	
	private String nome;
	private String email;
	private static int count;
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		
		int num = 1;
		
		if(arg0.getSession().getAttribute("usuarios_sessao") != null){
		    num = (int) arg0.getSession().getAttribute("usuarios_sessao");
		    num += 1;
		}		
		
		arg0.getSession().setAttribute("usuarios_sessao", num);
		
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		
		
	}
	

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
