package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.jpa.BuscaTarefas;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:loginForm";
	}

	@RequestMapping("loginForm")
	  public String loginForm() {
	    return "formulario-login";
	  }

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
	  if(new JdbcUsuarioDao().existeUsuario(usuario)) {
		
		  Usuario uu =  new JdbcUsuarioDao().buscaUsuario(usuario);
		  session.setAttribute("usuarioLogado", uu);
	    return "redirect:listaCampeonatos";
	  }
	  return "redirect:loginForm";
	}

	
	
}
