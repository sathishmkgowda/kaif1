package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.catalina.Manager;

import DTO.RegisterCreate;

public class RegisterAccess {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(RegisterCreate st) {

		entityTransaction.begin();
		entityManager.persist(st);
		entityTransaction.commit();
	}

	public List<RegisterCreate> fetchAll() {

		return entityManager.createQuery("select x from Student x").getResultList();
	}

	public RegisterCreate fetchid(int id) {
		return entityManager.find(RegisterCreate.class, id);
	}

	public List<RegisterCreate> fetchmobile(long mobile) {
		return entityManager.createQuery("select x from Student x where mobile=?1").setParameter(1, mobile)
				.getResultList();
	}
}