package fr.istic.tpjpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
	    Person p = new Person("Lecoq", "Xavier", "homme", "inexistant", "3 août 1990");
		Home h1 = new Home("32, rue Mirabeau", "35700", "123-456-789", p);
		Home h2 = new Home("31, rue Mirabeau", "35700", "123-456-789", p);
		Home h3 = new Home("30, rue Mirabeau", "35700", "123-456-789", p);
		Home h4 = new Home("33, rue Mirabeau", "35700", "123-456-789", p);

		test.manager.persist(h1);
		test.manager.persist(h2);
		test.manager.persist(h3);
		test.manager.persist(h4);

		test.manager.persist(p);

		tx.commit();

		System.out.println(".. done");
	}

}
