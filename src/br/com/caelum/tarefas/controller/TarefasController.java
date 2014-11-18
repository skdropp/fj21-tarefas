package br.com.caelum.tarefas.controller;

import javax.persistence.Id;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.dao.TarefaDao;
import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Jogador;
import br.com.caelum.tarefas.modelo.Usuario;

@Transactional
@Controller
public class TarefasController {

	@Autowired
	TarefaDao dao;

	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletResponse response) {

		dao.finaliza(id);
		response.setStatus(200);
	}

	@RequestMapping("mataMata")
	public String mataMata() {
		return "tarefa/modo-matamata";
	}

	@RequestMapping("adicionaJogador")
	public String adiciona(@Valid Jogador jogador, BindingResult result,
			HttpSession session) {

		if (result.hasFieldErrors("nome")) {
			return "redirect:listaJogadores";
		}
		// carrega o campeonato da sessao
		Campeonato campeonatoSessao = (Campeonato) session
					.getAttribute("campeonato");
				jogador.setIdCampeonato(campeonatoSessao.getId());


		dao.adiciona(jogador);
		return "redirect:listaJogadores";

	}

	@RequestMapping("removeJogador")
	public String remove(Jogador jogador) {

		dao.remove(jogador);
		return "redirect:listaJogadores";

	}

	@RequestMapping("listaJogadores")
	public String listaJogadores(HttpSession session,Model model) {

		// carrega o campeonato da sessao
		Campeonato campeonatoSessao = (Campeonato) session
				.getAttribute("campeonato");
		Long id = campeonatoSessao.getId();

		
		session.setAttribute("jogadores", dao.listaPeloId(id));
		return "redirect:listaConfrontos";

	}

}
