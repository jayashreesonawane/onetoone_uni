package onetoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_uni.dto.AadharCard;
import onetoone_uni.dto.Person;

public class AadharCardDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void deleteAadharCard(int id) {
		AadharCard aadharCard = entityManager.find(AadharCard.class, id);

		if (aadharCard != null) {
			entityTransaction.begin();
			entityManager.remove(aadharCard);
			entityTransaction.commit();
			System.out.println(aadharCard);
		} else {
			System.out.println("Aadhar Card with id " + id + " is not found");
		}

	}
	
	
}
