package br.com.caelum.tarefas.dao;

import java.util.List;

import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Confrontos;
import br.com.caelum.tarefas.modelo.Jogador;

public interface ConfrontosDao {
	
	Confrontos buscaPorId(Long id);

	List<Confrontos> listaPeloId(Long id );
	
	void adiciona(Confrontos confrontos);

	void altera(Confrontos confrontos);

	void remove(Long id);

	void finaliza(Long id);
}
