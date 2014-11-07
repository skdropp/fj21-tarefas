package br.com.caelum.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Jogador;
import br.com.caelum.tarefas.modelo.Usuario;

@Repository
public class JpaTarefaDao implements TarefaDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public Jogador buscaPorId(Long id) {
		return manager.find(Jogador.class, id);
	}

	@Override
	public List<Jogador> lista() {
		return manager.createQuery("select jogador from Jogador jogador")
				.getResultList();
	}

	@Override
	public void adiciona(Jogador jogador) {

		manager.persist(jogador);

	}

	@Override
	public void altera(Jogador jogador) {
		manager.merge(jogador);

	}

	@Override
	public void remove(Jogador jogador) {
		Jogador jogadorARemover = buscaPorId(jogador.getId());
		manager.remove(jogadorARemover);

	}

	@Override
	public void finaliza(Long id) {

	}

	@Override
	public List<Jogador> listaPeloId(Long id) {
		Query query = this.manager
				.createQuery("select jogador FROM Jogador jogador WHERE jogador.idCampeonato = ?");
		query.setParameter(1, id);
		return query.getResultList();
	}

	

	
	
}
