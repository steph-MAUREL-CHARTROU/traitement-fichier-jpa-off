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

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

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

	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete

}
