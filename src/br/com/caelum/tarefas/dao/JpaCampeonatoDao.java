package br.com.caelum.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Campeonato;

@Repository
public class JpaCampeonatoDao implements CampeonatoDao {

	@PersistenceContext
	EntityManager manager;

	
	@Override
	public Campeonato buscaPorId(Long id) {
		return manager.find(Campeonato.class, id);
	}

	@Override
	public List<Campeonato> listaPeloIdUsuario(Long idUsuario) {
		Query query = this.manager
				.createQuery("select campeonato FROM Campeonato campeonato WHERE campeonato.idUsuario = ?");
		query.setParameter(1, idUsuario);
		return query.getResultList();
	}

	@Override
	public List<Campeonato> lista() {

		return manager.createQuery(
				"select campeonato from Campeonato campeonato ")
				.getResultList();

	}

	@Override
	public void adiciona(Campeonato campeonato) {
		manager.persist(campeonato);
	}

	@Override
	public void altera(Campeonato campeonato) {
		manager.merge(campeonato);

	}

	@Override
	public void remove(Campeonato campeonato) {
		Campeonato campeonatoARemover = buscaPorId(campeonato.getId());
		manager.remove(campeonatoARemover);

	}

	@Override
	public void finaliza(Long id) {
		// TODO Auto-generated method stub

	}

}
