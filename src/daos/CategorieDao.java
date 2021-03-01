package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Categorie;

/**
 * 
 * @author StephanieMC
 *
 */

public class CategorieDao extends AbstractDao {

	// connection via la classe AbstractDao qui centralise

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public CategorieDao() {

	}

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

	public static Categorie insertCategorie(String[] tabInfoProd) {

		String nomCategorie = tabInfoProd[0];

		if (nomCategorie.length() <= 255) {

			Categorie categorie = new Categorie(null);

			TypedQuery<Categorie> query = em.createQuery(
					"SELECT categorie FROM Categorie categorie WHERE categorie.nomCategorie = ?1", Categorie.class);
			query.setParameter(1, categorie.getNomCategorie());
			List<Categorie> listCategorie = query.getResultList();

			if (listCategorie.isEmpty()) {

				transaction.begin();

				categorie = new Categorie();
				categorie.setNomCategorie(nomCategorie);

				em.persist(categorie);
				transaction.commit();

			} else {

				categorie = listCategorie.get(0);

			}

			return categorie;
		}
		return null;

	}

	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete

}
