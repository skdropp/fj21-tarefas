package br.com.caelum.tarefas.dao;

import java.util.List;

import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Confrontos;
import br.com.caelum.tarefas.modelo.Jogador;

public interface ConfrontosDao {

	Confrontos buscaPorId(Long id);

	List<Confrontos> listaPeloIdUsuario(Long idUsuario );
	
	List<Confrontos> lista();

	void adiciona(Confrontos confrontos);

	void altera(Confrontos confrontos);

	void remove(Confrontos confrontos);

	void finaliza(Long id);
}
