package onetoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetoone_uni.dto.AadharCard;
import onetoone_uni.dto.Person;

public class PersonDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePerson(Person person) {
		AadharCard aadharCard = person.getAadharCard();
		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void getPerson(int id) {
		Person person = entityManager.find(Person.class, id);
		;
		if (person != null) {

			System.out.println(person);
		} else {
			System.out.println("Person is not found");
		}
	}

	public void getAllPersons() {
		Query query = entityManager.createQuery("SELECT p FROM Person p");
		System.out.println(query.getResultList());
	}

	public void deletePerson(int id) {
		Person person = entityManager.find(Person.class, id);
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		} else {
			System.out.println("Person with id " + id + " is not found");
		}
	}
	
	public void updatePerson(int id, Person person)
	{
		Person dbPerson = entityManager.find(Person.class, id);
		if (dbPerson != null) {
			person.setId(dbPerson.getId());
			person.setAadharCard(dbPerson.getAadharCard());
			
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Person with given id "+id+ " is not found");
		}
	}

	public void updateBoth(int id, Person person) {
		Person dbPerson = entityManager.find(Person.class, id);
		if (dbPerson != null) {
			person.setId(id);
			//person.setAadharCard(dbPerson.getAadharCard());
			person.getAadharCard().setId(dbPerson.getAadharCard().getId());//method chaining
			entityTransaction.begin();
			entityManager.merge(person.getAadharCard());
			entityManager.merge(person);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("Person with given id "+id+ " is not found");
		}
		
		
	}
	
	public void updatePersonWithAadharCard(int pid, int aid)
	{
		Person person = entityManager.find(Person.class, pid);
		if (person!=null) {
			
			AadharCard aadharCard = entityManager.find(AadharCard.class, aid);
			if (aadharCard!=null) {
				person.setAadharCard(aadharCard);
				entityTransaction.begin();
				entityManager.merge(person);
				entityTransaction.commit();
			} else {
				System.out.println("Aadhar card not found");
			}
		} else {
			System.out.println("Person id not found");
		}
	}

}
