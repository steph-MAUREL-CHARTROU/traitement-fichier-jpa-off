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


		// ----------------- M�thodes CRUD------------------//

			// Ins�rer en base de donn�es

			public void insertAllergene( Allergene allergene) {
				transaction.begin();

				em.persist(allergene);

				transaction.commit();
			}

			// TODO R�cup�rer par ID
			// TODO R�cup�rer toute la liste
			// TODO update
			// TODO delete

}
