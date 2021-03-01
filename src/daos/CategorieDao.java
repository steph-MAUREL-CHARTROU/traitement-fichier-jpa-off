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

	private EntityManager em = AbstractDao.emf.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public CategorieDao() {

	}

	// ----------------- M�thodes CRUD------------------//

	// Ins�rer en base de donn�es

	public void insertCategorie(Categorie categorie) {

		TypedQuery<Categorie> query = em.createQuery(
				"SELECT categorie FROM Categorie categorie WHERE categorie.nomCategorie = ?1", Categorie.class);
		query.setParameter(1, categorie.getNomCategorie());
		List<Categorie> listCategorie = query.getResultList();

		if (listCategorie.isEmpty()) {

			transaction.begin();

			em.persist(categorie);

			transaction.commit();

		}

	}

	// TODO R�cup�rer par ID
	// TODO R�cup�rer toute la liste
	// TODO update
	// TODO delete

}
