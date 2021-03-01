package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Produit;

public class ProduitDao extends AbstractDao {

	// connection via la classe AbstractDao qui centralise

	private EntityManager em = AbstractDao.emf.createEntityManager();
	private EntityTransaction transaction = em.getTransaction();

	public ProduitDao() {

	}

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

	public void insertProduit(Produit produit) {
		transaction.begin();

		em.persist(produit);

		transaction.commit();
	}

	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete

}
