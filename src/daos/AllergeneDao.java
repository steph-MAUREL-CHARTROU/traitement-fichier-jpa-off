package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Allergene;
import entities.Categorie;


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
				
				
				TypedQuery<Allergene> query = em.createQuery(
						"SELECT allergene FROM Allergene allergene WHERE allergene.nomAllergene = ?1", Allergene.class);
				query.setParameter(1, allergene.getNomAllergene());
				List<Allergene> listAllergene = query.getResultList();

				if (listAllergene.isEmpty()) {

					transaction.begin();

					em.persist(allergene);

					transaction.commit();
			}

			// TODO R�cup�rer par ID
			// TODO R�cup�rer toute la liste
			// TODO update
			// TODO delete

}
}