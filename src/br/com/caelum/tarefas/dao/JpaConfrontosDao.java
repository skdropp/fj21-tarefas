package br.com.caelum.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.IdClass;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Campeonato;
import br.com.caelum.tarefas.modelo.Confrontos;
import br.com.caelum.tarefas.modelo.Jogador;

@Repository
public class JpaConfrontosDao implements ConfrontosDao {

	@PersistenceContext
	EntityManager manager;

	
	@Override
	public Confrontos buscaPorId(Long id) {
		return manager.find(Confrontos.class, id);
	}
	

	@Override
	public List<Confrontos> listaPeloId(Long id) {
		Query query = this.manager
				.createQuery("select confrontos FROM Confrontos confrontos WHERE confrontos.idCampeonato = ?");
		query.setParameter(1, id);
		return query.getResultList();
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
	public void remove(Long id) {
		// TODO Auto-generated method stub
		Query query = this.manager
				.createQuery("delete   FROM Confrontos  confrontos WHERE confrontos.idCampeonato = ?");
		query.setParameter(1, id);
		query.executeUpdate();
	}
	
		
	@Override
	public Confrontos confereSeTemConfrontos(Long idCampeonato) {
		// TODO Auto-generated method stub
		Query query = this.manager.createQuery("select confrontos from Confrontos confrontos where confrotos.idCampeonato = :name");
        query.setParameter("name", idCampeonato);
        return (Confrontos) query.getSingleResult();
		
	}

	@Override
	public void finaliza(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
