package entities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import daos.CategorieDao;
import daos.IngredientDao;
import daos.MarqueDao;
import daos.ProduitDao;

/**
 * 
 * 
 * @author StephanieMC
 *
 */

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {

		// ------------Lecture du fichier à mettre en base ------------//
		
		Path pathBase = Paths.get(
				"C:\\Users\\33782\\Desktop\\DiginamicWork\\java\\traitement-fichier-jpa-off\\resources\\fichierSource\\open-food-facts.csv");

		// -----------Récupération des lignes du fichier et stockage dans une liste de type String---------//
		
		List<String> lines = Files.readAllLines(pathBase, StandardCharsets.UTF_8);
		if (lines == null) {

			System.out.println(" STOP // erreur d'execution ");
		}

		// ------------ retrait de l'entête [0]----------------------//
		
		lines.remove(0);

		int compteur = 1;

		for (String infos : lines) {

			System.out.println(compteur);

			// ------------ Conversion du CSV en Tableau -----------------//
			
			String[] tabInfoProd = infos.split("\\|", -1);
			
			//----------------Insertion des données en base via les DAO------------------------//
			
			Categorie categorie = CategorieDao.insertCategorie(tabInfoProd);
			Marque marque = MarqueDao.insertMarque(tabInfoProd);
			Produit produit = ProduitDao.insertProduit(tabInfoProd, categorie, marque);
			IngredientDao.insertIngredient(tabInfoProd, produit);
			

			compteur++;

		}

	}

}