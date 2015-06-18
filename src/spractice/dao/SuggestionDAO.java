package spractice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	
	public void getSu() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Suggestion> criteriaQuery = criteriaBuilder.createQuery(Suggestion.class);
		Root<Suggestion> root=	criteriaQuery.from(Suggestion.class);
		criteriaQuery.select(root).orderBy( criteriaBuilder.desc(root.get("createDate")));
		List<Suggestion> suggestions=	entityManager.createQuery(criteriaQuery).getResultList();
		System.out.println(suggestions);
	}
	
	public List<Suggestion> getLatestNRecords(int n) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		CriteriaBuilder builder= entityManager.getCriteriaBuilder();
		CriteriaQuery<Suggestion> query= builder.createQuery(Suggestion.class);
		Root<Suggestion> rootS=	query.from(Suggestion.class);
		query.orderBy(builder.desc(rootS.get("createDate")));
		TypedQuery<Suggestion> typedQuery=	entityManager.createQuery(query);
		typedQuery.setMaxResults(n);
		List<Suggestion> suggestions=	typedQuery.getResultList();
		return suggestions;
	}
	
	public List<Suggestion> getLatestNRecordsUsingJPQL(int n) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		TypedQuery<Suggestion> query= entityManager.createQuery("select s from Suggestion s order by s.createDate desc",Suggestion.class);
		query.setMaxResults(n);
		List<Suggestion> suggestions=	query.getResultList();
		return suggestions;
	}

	public List<Suggestion> get(String keyword) {
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		String query1="select NEW spractice.model.Suggestion(s.id,s.category,s.information,s.createDate) from Suggestion s";
		TypedQuery<Suggestion> cq= entityManager.createQuery(query1,Suggestion.class);
		List<Suggestion> suggestions2= cq.getResultList();
		List<Suggestion> suggestions = new ArrayList<Suggestion>();
		for (int i = 0; i < suggestions2.size();i++ ) {
			Suggestion suggestion= suggestions2.get(i);
			if (suggestion.getCategory().contains(keyword)) {
				suggestions.add(suggestion);
			}
		}
		return suggestions;
	}
	
}
