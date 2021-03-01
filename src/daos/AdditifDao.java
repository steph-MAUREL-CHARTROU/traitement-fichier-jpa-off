package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.Additif;
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

	public void insertAdditif( Additif additif) {
		transaction.begin();

		em.persist(additif);

		transaction.commit();
	}

	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete

}
