package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomIngredient;

	@ManyToMany
	@JoinTable(name = " TB_PROD_INGRDT", joinColumns = @JoinColumn(name = "INGRDT_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = " id"))
	private List<Produit> produits;

	public Ingredient() {

	}

	public Ingredient(String nomIngredient) {

		this.nomIngredient = nomIngredient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomIngredient() {
		return nomIngredient;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
