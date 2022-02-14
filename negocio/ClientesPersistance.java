package com.example.demo.negocio;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class ClientesPersistance {
	@PersistenceContext
	private EntityManager entityManager;

	public long insert(Clientes1 user) {
		entityManager.persist(user);
		return user.getCod_cliente();
	}

	public long updates(Clientes1 user) {
		Clientes1 c1 = find(user.getCod_cliente());
		if (c1 != null) {
			c1.setNombre(user.getNombre());
			c1.setDni(user.getDni());
			c1.setApellidos(user.getApellidos());
			c1.setDireccion(user.getDireccion());
			c1.setTelefono(user.getTelefono());
			entityManager.persist(c1);
			return user.getCod_cliente();
		} else
			return -1;
	}

	public long deteById(long id) {
		Clientes1 c1 = find(id);
		if (c1 != null) {
			entityManager.remove(c1);
			return id;
		} else
			return -1;
	}

	public Clientes1 find(long id) {
		return entityManager.find(Clientes1.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Clientes1> findAll() {
		Query query = (Query) entityManager.createNamedQuery("query_find_all_clientes", Clientes1.class);
		return ((javax.persistence.Query) query).getResultList();
	}
}
