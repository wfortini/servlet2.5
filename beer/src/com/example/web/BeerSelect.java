package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.BeerExpert;
import com.example.model.Cargo;
import com.example.model.Empregado;
import com.example.model.Pessoa;
import com.example.model.Usuario;

public class BeerSelect extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, String> mapa = new HashMap<String, String>();
		
		mapa.put("fido", "Cachorro fido");
		mapa.put("bob", "Cachorro Bob");
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
				
		String c = req.getParameter("color");
		String nome = req.getParameter("nome");
		
		List<String> result = new BeerExpert().getBrands(c);
		
		//for(String x : result){	
		//	out.print("<br>Try: " + x);
		//}
		
		//out.println("Got beer color " + c);
		
		req.setAttribute("style", result);
		
		//req.setAttribute("email", getServletConfig().getInitParameter("email"));		
		//req.setAttribute("adminEmail", getServletContext().getInitParameter("adminEmail"));
		
		// EL -----------------------
		Empregado empregado = new Empregado();
		Cargo cargo = new Cargo();
		cargo.setDescricao("Arquiteto");
		empregado.setCargo(cargo);
		
		req.setAttribute("empregado", empregado);
		//EL ---------------------------------
		
		String[] lista = {"Wellington", "Wallace", "Adriana"};
		
		req.setAttribute("lista", lista);
		
		Cookie cookie = new Cookie("userName", nome);
		cookie.setMaxAge(30*60);
		
		resp.addCookie(cookie);
		
		HttpSession sessao = req.getSession();
		
		//userBean
		sessao.setAttribute("usuarioLogado", new Usuario("eu", "teste"));
		
		Pessoa pessoa = new Empregado();
		pessoa.setNome("Wellington Fortini ");
		req.setAttribute("pessoa", pessoa);
		
		Usuario usuario = (Usuario) getServletContext().getAttribute("usuario");
		
		req.setAttribute("nome", usuario.getNome());
		req.setAttribute("email", usuario.getEmail());
		
		RequestDispatcher view  = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);
		
	}

}
