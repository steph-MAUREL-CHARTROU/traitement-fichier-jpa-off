package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table (name= "CATEGORIE")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom_categorie;
	
	@OneToMany(mappedBy="categorie_produit")
	private List<Produit> produits;
	
	
	public Categorie() {
	
	}

	public Categorie(int id, String nom_categorie) {
		super();
		this.id = id;
		this.nom_categorie = nom_categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_categorie() {
		return nom_categorie;
	}

	public void setNom_categorie(String nom_categorie) {
		this.nom_categorie = nom_categorie;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom_categorie=" + nom_categorie + "]";
	}
	
	

}
