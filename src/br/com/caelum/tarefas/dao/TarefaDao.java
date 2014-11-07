package br.com.caelum.tarefas.dao;

import java.util.List;

import org.springframework.ui.Model;

import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Jogador;
import br.com.caelum.tarefas.modelo.Usuario;

public interface TarefaDao {

	Jogador buscaPorId(Long id);

	List<Jogador> listaPeloId(Long id );
	
	List<Jogador> lista();

	void adiciona(Jogador jogador);

	void altera(Jogador jogador);

	void remove(Jogador jogador);

	void finaliza(Long id);

}
