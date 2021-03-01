package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Categorie;
import entities.Marque;

/**
 * 
 * @author StephanieMC
 *
 */

public class MarqueDao extends AbstractDao {

	// connection via la classe AbstractDao qui centralise

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public MarqueDao() {

	}

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

	public static Marque insertMarque(String[] tabInfoProd) {

		String nomMarque = tabInfoProd[1];

		if (nomMarque.length() <= 255) {

			Marque marque = new Marque(null);

			TypedQuery<Marque> query = em.createQuery("SELECT marque FROM Marque marque WHERE marque.nomMarque = ?1",
					Marque.class);
			query.setParameter(1, nomMarque);

			List<Marque> listMarque = query.getResultList();

			if (listMarque.isEmpty()) {

				
				transaction.begin();
				marque = new Marque();
				marque.setNomMarque(nomMarque);
				
				em.persist(marque);

				transaction.commit();
				
			} else {
				
				marque = listMarque.get(0);
			}
			
			return marque;

		}
		return null;
	}
	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete

}
