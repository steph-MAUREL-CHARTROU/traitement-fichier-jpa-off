package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Categorie;
import entities.Marque;
import entities.Produit;
import utils.Parser;

public class ProduitDao extends AbstractDao {

	// connection via la classe AbstractDao qui centralise

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public ProduitDao() {

	}

	// ----------------- Méthodes CRUD------------------//

	// Insérer en base de données

	public static Produit insertProduit(String[] tabInfoProd, Categorie categorie, Marque marque) {

		Produit produit = new Produit(null);

		String nomProduit = tabInfoProd[2];

		if (nomProduit.length() <= 255) {

			produit.setNomProduit(nomProduit);

			String nutriGradeFr = tabInfoProd[3];
			Double energie100gr = Parser.parseDouble(tabInfoProd[5]); // Parser() = methode dans le package utils
			Double graisse100gr = Parser.parseDouble(tabInfoProd[6]);
			Double sucres100gr = Parser.parseDouble(tabInfoProd[7]);
			Double fibres100gr = Parser.parseDouble(tabInfoProd[8]);
			Double protein100gr = Parser.parseDouble(tabInfoProd[9]);
			Double sel100gr = Parser.parseDouble(tabInfoProd[10]);

			produit.setNutritionGradeFrProduit(nutriGradeFr);
			produit.setEnergie100grProduit(energie100gr);
			produit.setGraisse100grProduit(graisse100gr);
			produit.setSucres100grProduit(sucres100gr);
			produit.setSel100grProduit(sel100gr);
			produit.setFibres100grProduit(fibres100gr);
			produit.setProtein100grProduit(protein100gr);

			produit.setCategorie(categorie);
			produit.setMarque(marque);

			TypedQuery<Produit> query = em.createQuery(
					"SELECT produit FROM Produit produit JOIN  produit.marque marque WHERE produit.nomProduit = ?1 AND marque.nomMarque = ?2 ",
					Produit.class);
			query.setParameter(1, nomProduit);
			query.setParameter(2, marque.getNomMarque());
			List<Produit> listProduit = query.getResultList();

			if (listProduit.isEmpty()) {

				transaction.begin();

				em.persist(produit);

				transaction.commit();

			} else {

				produit = listProduit.get(0);
			}

			return produit;
		} else {
			return null;
		}

	}

	// TODO Récupérer par ID
	// TODO Récupérer toute la liste
	// TODO update
	// TODO delete

}
