package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.Allergene;


/**
 * 
 * @author StephanieMC
 *
 */

public class AllergeneDao extends AbstractDao {
	
	// connection via la classe AbstractDao qui centralise

		private EntityManager em = AbstractDao.emf.createEntityManager();
		private EntityTransaction transaction = em.getTransaction();
		
		public AllergeneDao() {
			
		}


		// ----------------- Méthodes CRUD------------------//

			// Insérer en base de données

			public void insertAllergene( Allergene allergene) {
				transaction.begin();

				em.persist(allergene);

				transaction.commit();
			}

			// TODO Récupérer par ID
			// TODO Récupérer toute la liste
			// TODO update
			// TODO delete

}
