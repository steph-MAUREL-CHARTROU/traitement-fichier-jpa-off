package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * 
 * @author StephanieMC
 *
 */

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp-yucca");
		EntityManager em = entityManagerFactory.createEntityManager();
		

	}

}