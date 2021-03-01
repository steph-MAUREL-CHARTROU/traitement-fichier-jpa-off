package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Ingredient;
import entities.Marque;
import entities.Produit;

/**
 * 
 * @author StephanieMC
 *
 */
public class IngredientDao extends AbstractDao {

	// connection via la classe AbstractDao qui centralise

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public IngredientDao() {

	}

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

	public static void insertIngredient(String[] tabInfoProd, Produit produit) {

		String[] ingredients = tabInfoProd[4].split("[,;-]", -1);

		for (String ingredient : ingredients) {

			if (ingredient.length() <= 255) {

				transaction.begin();

				Ingredient ingrt = null;

				TypedQuery<Ingredient> query = em.createQuery(
						"SELECT ingredient FROM Ingredient ingredient marque WHERE ingredient.nomIngredient = ?1",
						Ingredient.class);
				query.setParameter(1, ingredient);

				List<Ingredient> listIngredient = query.getResultList();

				if (listIngredient.isEmpty()) {

					ingrt = new Ingredient();
					ingrt.setNomIngredient(ingredient);

					em.persist(ingredient);

				} else {

					ingrt = listIngredient.get(0);

				}

				produit.getIngredients().add(ingrt);
				transaction.commit();
			}
		}

	}

	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete

}
