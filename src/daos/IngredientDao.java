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
	
	// ----------------- M�thodes CRUD------------------//

		// Ins�rer en base de donn�es

		public void insertIngredient( Ingredient ingredient) {
			transaction.begin();

			em.persist(ingredient);

			transaction.commit();
		}

		// TODO R�cup�rer par ID
		// TODO R�cup�rer toute la liste
		// TODO update
		// TODO delete

}
