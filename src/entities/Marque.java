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
@Table ( name = "MARQUE")
public class Marque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomMarque;
	
	
	@OneToMany(mappedBy="marque")
	private List<Produit> produits;
	
	
	public Marque() {
		
	}


	public Marque(int id, String nomMarque, List<Produit> produits) {
		super();
		this.id = id;
		this.nomMarque = nomMarque;
		this.produits = produits;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomMarque() {
		return nomMarque;
	}


	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}


	@Override
	public String toString() {
		return "Marque [id=" + id + ", nomMarque=" + nomMarque + ", produits=" + produits + "]";
	}

	

}
