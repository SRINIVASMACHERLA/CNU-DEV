package spractice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import spractice.model.Suggestion;

public class SuggestionDAO {
	private EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("jpa-persistence-id");

	public void add(Suggestion suggestion) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		suggestion.setId(get() + 1);
		entityManager.persist(suggestion);
		entityTransaction.commit();
		entityManager.close();
	}

	public List<Suggestion> getAllSuggestions() {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Query query = entityManager.createQuery("select s from Suggestion s",
				Suggestion.class);
		@SuppressWarnings("unchecked")
		List<Suggestion> suggestions = query.getResultList();
		entityManager.close();
		return suggestions;
	}

	public Long get() {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		Query query = entityManager
				.createQuery("SELECT MAX(s.id) FROM Suggestion s");
		Object object = query.getSingleResult();
		entityManager.close();
		if (object == null) {
			return 0L;
		}
		return (Long) object;
	}
}
