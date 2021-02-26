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
	private String nom_marque;
	
	
	@OneToMany(mappedBy="marque_produit")
	private List<Produit> produits;
	
	
	public Marque() {
		
	}

	public Marque(int id, String nom_marque) {
		super();
		this.id = id;
		this.nom_marque = nom_marque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_marque() {
		return nom_marque;
	}

	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}

	@Override
	public String toString() {
		return "Marque [id=" + id + ", nom_marque=" + nom_marque + "]";
	}
	
	
	
	

}
