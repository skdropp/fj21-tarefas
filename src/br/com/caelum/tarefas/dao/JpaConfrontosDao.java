package br.com.caelum.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Confrontos;

@Repository
public class JpaConfrontosDao implements ConfrontosDao {

	@PersistenceContext
	EntityManager manager;

	
	@Override
	public Confrontos buscaPorId(Long id) {
		return manager.find(Confrontos.class, id);
	}
	@Override
	public List<Confrontos> listaPeloIdUsuario(Long idUsuario) {
		Query query = this.manager
				.createQuery("select confrontos FROM Confrontos confronto WHERE confronto.idCampeonato = ?");
		query.setParameter(1, idUsuario);
		return query.getResultList();
	}

	@Override
	public List<Confrontos> lista() {

		return manager.createQuery(
				"select campeonato from Campeonato campeonato ")
				.getResultList();

	}

	@Override
	public void adiciona(Confrontos confontros) {
		manager.persist(confontros);
	}

	@Override
	public void altera(Confrontos confontros) {
		manager.merge(confontros);

	}

	@Override
	public void remove(Confrontos confontros) {
		Confrontos confrontoARemover = buscaPorId(confontros.getId());
		manager.remove(confrontoARemover);

	}

	@Override
	public void finaliza(Long id) {
		// TODO Auto-generated method stub

	}

}
