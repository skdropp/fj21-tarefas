package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.CampeonatoDao;
import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Jogador;
import br.com.caelum.tarefas.modelo.Usuario;

@Transactional
@Controller
public class CampeonatoController {

	@Autowired
	CampeonatoDao dao;

	
	
	@RequestMapping("listaCampeonatos")
	public String listalistaPeloIdUsuario(Model model, HttpSession session) {

		// carrega o usuario da sessao
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");

		model.addAttribute("campeonatos", dao.listaPeloIdUsuario(usuarioSessao.getId()));
		return "campeonato/tela-inicial";

	}

	/*
	 * @RequestMapping("listaCampeonatos") public String listaCampeonatos(Model
	 * model) {
	 * 
	 * 
	 * model.addAttribute("campeonatos", dao.lista()); return
	 * "campeonato/tela-inicial";
	 * 
	 * }
	 */
	
	// //////////////////////////////////////////////
	@RequestMapping("carregarCampeonato")
	public String carregarCampeonato(Campeonato campeonato, HttpSession session) {

		 session.setAttribute("campeonato", campeonato);
				
		return "redirect:listaJogadores";

	}
	
	
	
	///////////////////////////
	@RequestMapping("adicionaCampeonato")
	public String adiciona(@Valid Campeonato campeonato, BindingResult result,
			HttpSession session) {

		if (result.hasFieldErrors("nome")) {
			return "campeonato/tela-inicial";
		}

		// carrega o usuario da sessao
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");

		campeonato.setIdUsuario(usuarioSessao.getId());

		dao.adiciona(campeonato);
		return "redirect:listaCampeonatos";

	}

	// ////////////////////////////////////////////////////////
	@RequestMapping("removeCampeonato")
	public String removeCampeonato(Campeonato campeonato) {

		dao.remove(campeonato);
		return "redirect:listaCampeonatos";

	}
	// /////////////////////////////////////////////////////////

}