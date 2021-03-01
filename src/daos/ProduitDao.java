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

	// ----------------- M�thodes CRUD------------------//

	// Ins�rer en base de donn�es

	public void insertProduit(Produit produit) {
		transaction.begin();

		em.persist(produit);

		transaction.commit();
	}

	// TODO R�cup�rer par ID
	// TODO R�cup�rer toute la liste
	// TODO update
	// TODO delete

}
