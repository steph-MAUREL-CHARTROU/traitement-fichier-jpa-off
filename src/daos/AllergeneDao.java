package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import entities.Allergene;
import entities.Produit;

/**
 * 
 * @author StephanieMC
 *
 */

public class AllergeneDao extends AbstractDao {

	// connection via la classe AbstractDao qui centralise

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public AllergeneDao() {

	}

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

	public static void insertAllergene(String[] tabInfoProd, Produit produit) {

		String[] allergenes = tabInfoProd[28].split("[,]", -1);

		for (String allergene : allergenes) {

			if (allergene.length() >= 255) {

				Allergene allergn = null;

				TypedQuery<Allergene> query = em.createQuery(
						"SELECT allergene FROM Allergene allergene WHERE allergene.nomAllergene = ?1", Allergene.class);
				query.setParameter(1, allergene);
				List<Allergene> listAllergene = query.getResultList();

				if (listAllergene.isEmpty()) {

					transaction.begin();
					allergn = new Allergene();
					allergn.setNomAllergene(allergene);

					em.persist(allergene);

					transaction.commit();
				} else {

					allergn = listAllergene.get(0);
				}

				produit.getAllergenes().add(allergn);

			}

		}
	}
	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete
}