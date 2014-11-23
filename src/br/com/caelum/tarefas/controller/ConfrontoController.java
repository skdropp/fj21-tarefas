package br.com.caelum.tarefas.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.ConfrontosDao;
import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Confrontos;
import br.com.caelum.tarefas.modelo.Jogador;

@Transactional
@Controller
public class ConfrontoController {

	@Autowired
	ConfrontosDao dao;

	@RequestMapping("confereSeTemConfrontosDoCampeonato")
	public String confereTemConfrontosDoCampeonato(HttpSession session) {

		// carrega o campeonato da sessao
		Campeonato campeonatoSessao = (Campeonato) session
				.getAttribute("campeonato");
		Long id = campeonatoSessao.getId();

		List<Confrontos> l = dao.listaPeloId(id);
		if (l.isEmpty() == true)  {

			return "redirect:geraConfrontos";
		}
		return "tarefa/aviso";

	}

	@RequestMapping("removeConfrontos")
	public String removeConfrontos(HttpSession session) {

		// apaga a lista de confrontos da sessao
		session.removeAttribute("confrontos");

		// carrega o campeonato da sessao
		Campeonato campeonatoSessao = (Campeonato) session
				.getAttribute("campeonato");
		Long id = campeonatoSessao.getId();

		dao.remove(id);
		return "redirect:geraConfrontos";

	}

	@RequestMapping("listaConfrontos")
	public String listaJogadores(HttpSession session, Model model) {

		// carrega o campeonato da sessao
		Campeonato campeonatoSessao = (Campeonato) session
				.getAttribute("campeonato");
		Long id = campeonatoSessao.getId();

		session.setAttribute("confrontos", dao.listaPeloId(id));
		return "tarefa/modo-matamata";

	}

	@RequestMapping("geraConfrontos")
	public String listaConfrontos(HttpSession session) {

		// carrega os jogadores da sessao

		List<Jogador> jogadoresDaSessao = (List<Jogador>) session
				.getAttribute("jogadores");

		for (int a = 0; a < jogadoresDaSessao.size(); a++) {
			Collections.swap(jogadoresDaSessao, 0, a);
			for (int i = 1; i < jogadoresDaSessao.size(); i++) {

				Confrontos confrontos = new Confrontos();
				confrontos.setIdCampeonato(jogadoresDaSessao.get(i)
						.getIdCampeonato());
				confrontos.setIdJogadorCasa(jogadoresDaSessao.get(0).getId());
				confrontos.setJogadorCasa(jogadoresDaSessao.get(0).getNome());
				confrontos.setIdJogadorFora(jogadoresDaSessao.get(i).getId());
				confrontos.setJogadorFora(jogadoresDaSessao.get(i).getNome());
				dao.adiciona(confrontos);

			}

		}
		return "redirect:listaJogadores";

	}

}
