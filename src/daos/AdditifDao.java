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

	// ----------------- M�thodes CRUD------------------//

	// Ins�rer en base de donn�es

	public void insertAdditif( Additif additif) {
		transaction.begin();

		em.persist(additif);

		transaction.commit();
	}

	// TODO R�cup�rer par ID
	// TODO R�cup�rer toute la liste
	// TODO update
	// TODO delete

}
