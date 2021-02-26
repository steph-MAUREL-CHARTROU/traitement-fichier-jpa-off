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
/**
 * 
 * 
 * @author StephanieMC
 *
 */

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp-yucca");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		
		Path pathBase= Paths.get("C://User/33782/Desktop/DiginamicWork/java/traitement-fichier-jpa-off/resources/fichierSource/open-food-facts.csv");
		
		List<String> lines= Files.readAllLines(pathBase, StandardCharsets.UTF_8);
		
		if ( lines == null) {
			
			System.out.println(" STOP // erreur d'execution ");
		}
		lines.remove(0); // je retire l'entête
		
		transaction.begin();
		
		for ( String infos : lines ) {
			
			String [] tabInfoProd = infos.split("\\|", -1); // Conversion du CSV en Tableau 
			
			// je récupère les infos du CSV
			
			String categorie = tabInfoProd [0];
			String nom_marque = tabInfoProd[1];
			String nom_produit = tabInfoProd[2];
			char nutriGradeFr = tabInfoProd[3].charAt(0);
			String ingredients = tabInfoProd[4];
			
			Double energie100gr = Double.parseDouble(tabInfoProd[5]);
			Double graisse100gr = Double.parseDouble(tabInfoProd[6]);
			Double sucres100gr = Double.parseDouble(tabInfoProd[7]);
			Double fibres100gr = Double.parseDouble(tabInfoProd[8]);
			Double protein100gr = Double.parseDouble(tabInfoProd[9]);
			Double sel100gr = Double.parseDouble(tabInfoProd[10]);
				
			
		}
		
	}

}