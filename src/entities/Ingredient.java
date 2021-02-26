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
	private String nom_ingredient;
	
	@ManyToMany
	@JoinTable(name = " TB_PROD_INGRDT", 
	joinColumns = @JoinColumn(name = "INGRDT_ID", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = " id"))
	private List<Produit> produits;
	

	public Ingredient() {

	}

	public Ingredient(int id, String nom_ingredient) {
		super();
		this.id = id;
		this.nom_ingredient = nom_ingredient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_ingredient() {
		return nom_ingredient;
	}

	public void setNom_ingredient(String nom_ingredient) {
		this.nom_ingredient = nom_ingredient;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom_ingredient=" + nom_ingredient + "]";
	}

}
