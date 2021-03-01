package daos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author StephanieMC
 *
 */

public class AbstractDao {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-yucca");

}
