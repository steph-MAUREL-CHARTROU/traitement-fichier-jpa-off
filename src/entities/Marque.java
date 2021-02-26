package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
public class Marque {
	
	@Id
	private int id;
	private String nom_marque;
	
	
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
