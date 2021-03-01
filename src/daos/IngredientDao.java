package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.Ingredient;
/**
 * 
 * @author StephanieMC
 *
 */
public class IngredientDao extends AbstractDao{
	
	// connection via la classe AbstractDao qui centralise

	private EntityManager em = AbstractDao.emf.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();
			
	public IngredientDao() {
		
	}
	
	// ----------------- Méthodes CRUD------------------//

		// Insérer en base de données

		public void insertIngredient( Ingredient ingredient) {
			transaction.begin();

			em.persist(ingredient);

			transaction.commit();
		}

		// TODO Récupérer par ID
		// TODO Récupérer toute la liste
		// TODO update
		// TODO delete

}
