package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Ingredient;
import entities.Marque;
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
			

			TypedQuery<Ingredient> query = em.createQuery("SELECT ingredient FROM Ingredient ingredient marque WHERE ingredient.nomIngredient = ?1",Ingredient.class);
			query.setParameter(1, ingredient.getNomIngredient());
			
			List<Ingredient> listIngredient = query.getResultList();

			if (listIngredient.isEmpty()) {

				transaction.begin();

				em.persist(ingredient);

				transaction.commit();
			} 
			
			
		}

		// TODO Récupérer par ID
		// TODO Récupérer toute la liste
		// TODO update
		// TODO delete

}
