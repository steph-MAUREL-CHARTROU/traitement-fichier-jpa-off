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

	private EntityManager em = AbstractDao.emf.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public MarqueDao() {

	}

	// ----------------- M�thodes CRUD------------------//

	// Ins�rer en base de donn�es

	public void insertMarque(Marque marque) {
		
		TypedQuery<Marque> query = em.createQuery("SELECT marque FROM Marque marque WHERE marque.nomMarque = ?1",Marque.class);
		query.setParameter(1, marque.getNomMarque());
		
		List<Marque> listMarque = query.getResultList();

		if (listMarque.isEmpty()) {

			transaction.begin();

			em.persist(marque);

			transaction.commit();
		}

		// TODO R�cup�rer par ID
		// TODO R�cup�rer toute la liste
		// TODO update
		// TODO delete

	}
}
