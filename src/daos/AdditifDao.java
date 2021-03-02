package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Additif;
import entities.Categorie;
import entities.Produit;

/**
 * 
 * @author StephanieMC
 *
 */

public class AdditifDao extends AbstractDao {

	// connection via la classe AbstractDao qui centralise

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public AdditifDao() {

	}

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

	public static void insertAdditif(String[] tabInfoProd, Produit produit) {

		String[] nomAdditif = tabInfoProd[29].split("[,]", -1);

		for (String additif : nomAdditif) {

			if (nomAdditif.length <= 255) {

				Additif additifs = null;

				TypedQuery<Additif> query = em.createQuery(
						"SELECT additif FROM Additif additif WHERE additif.nomAdditif = ?1", Additif.class);
				query.setParameter(1, additif);
				List<Additif> listAdditif = query.getResultList();

				if (listAdditif.isEmpty()) {

					transaction.begin();
					additifs = new Additif();
					additifs.setNomAdditif(additif);

					em.persist(additifs);

					transaction.commit();
				} else {

					additifs = listAdditif.get(0);
				}

			}
		}
	}

	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete
}
