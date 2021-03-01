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
	private String nomCategorie;
	
	@OneToMany(mappedBy="categorie")
	private List<Produit> produits;
	
	
	public Categorie() {
	
	}


	public Categorie(String nomCategorie) {
		
		this.nomCategorie = nomCategorie;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomCategorie() {
		return nomCategorie;
	}


	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}


	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nomCategorie=" + nomCategorie + ", produits=" + produits + "]";
	}

	

}
