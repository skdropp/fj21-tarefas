package br.com.caelum.tarefas.dao;

import java.util.List;

import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Jogador;

public interface CampeonatoDao {

	Campeonato buscaPorId(Long id);

	List<Campeonato> listaPeloIdUsuario(Long idUsuario );
	
	List<Campeonato> lista();

	void adiciona(Campeonato campeonato);

	void altera(Campeonato campeonato);

	void remove(Campeonato campeonato);

	void finaliza(Long id);
}
