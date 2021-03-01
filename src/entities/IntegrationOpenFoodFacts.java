package entities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import daos.AdditifDao;
import daos.AllergeneDao;
import daos.CategorieDao;
import daos.IngredientDao;
import daos.MarqueDao;
import daos.ProduitDao;
import utils.Parser;
/**
 * 
 * 
 * @author StephanieMC
 *
 */

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {
		
		
		// remettre l'entitymanager ici
		

		// ------------Lecture du fichier à mettre en base ------------//
		Path pathBase= Paths.get("C:\\Users\\33782\\Desktop\\DiginamicWork\\java\\traitement-fichier-jpa-off\\resources\\fichierSource\\open-food-facts.csv");
		
		
		// -----------Récupération des lignes du fichier et stockage dans une liste de type String---------//
		List<String> lines= Files.readAllLines(pathBase, StandardCharsets.UTF_8);
		if ( lines == null) {
			
			System.out.println(" STOP // erreur d'execution ");
		}
		
		//------------ retrait de l'entête [0]----------------------//
		lines.remove(0); 
		
		//---------INSERTION EN BASE À PARTIR DES DAOs---------------//
		
		
		ProduitDao produitDao = new ProduitDao();
		CategorieDao categorieDao = new CategorieDao();
		IngredientDao ingredientDao = new IngredientDao();
		MarqueDao marqueDao = new MarqueDao();
		AdditifDao additifDao = new AdditifDao();
		AllergeneDao allergeneDao = new AllergeneDao();
		
		
		for ( String infos : lines ) {
			
		
		// ------------ Conversion du CSV en Tableau -----------------//	
			String [] tabInfoProd = infos.split("\\|", -1);
			
			// -------------Récupération des données dans le CSV ------------------//
			
			String nomCategorie = tabInfoProd [0];
			String nomMarque = tabInfoProd[1];
			String nomProduit = tabInfoProd[2];
			char nutriGradeFr = tabInfoProd[3].charAt(0);
			String ingredients = tabInfoProd[4];
			
			Double energie100gr = Parser.parseDouble(tabInfoProd[5]);
			Double graisse100gr = Parser.parseDouble(tabInfoProd[6]);
			Double sucres100gr = Parser.parseDouble(tabInfoProd[7]);
			Double fibres100gr = Parser.parseDouble(tabInfoProd[8]);
			Double protein100gr = Parser.parseDouble(tabInfoProd[9]);
			Double sel100gr = Parser.parseDouble(tabInfoProd[10]);
			
			
			Categorie categorie = new Categorie(nomCategorie);
			categorieDao.insertCategorie(categorie);
			
			Marque marque = new Marque(nomMarque);
			marqueDao.insertMarque(marque);
			
		}
		
	//transation.commit();	
		
	}
	

}