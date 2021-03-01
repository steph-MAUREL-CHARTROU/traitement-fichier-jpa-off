package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Additif;
import entities.Categorie;

/**
 * 
 * @author StephanieMC
 *
 */

public class AdditifDao extends AbstractDao {

	// connection via la classe AbstractDao qui centralise

	private EntityManager em = AbstractDao.emf.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public AdditifDao() {

	}

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

	public void insertAdditif(Additif additif) {

		TypedQuery<Additif> query = em.createQuery("SELECT additif FROM Additif additif WHERE additif.nomAdditif = ?1",
				Additif.class);
		query.setParameter(1, additif.getNomAdditif());
		List<Additif> listAdditif = query.getResultList();

		if (listAdditif.isEmpty()) {

			transaction.begin();

			em.persist(additif);

			transaction.commit();
		}

		// TODO Récupérer par ID
		// TODO Récupérer toute la liste
		// TODO update
		// TODO delete
	}
}
