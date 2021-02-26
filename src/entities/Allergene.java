package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
public class Allergene {
	
	@Id
	private int id;
	private String nom_allergene;
	
	
	
	public Allergene() {
	
	}

	public Allergene(int id, String nom_allergene) {
		super();
		this.id = id;
		this.nom_allergene = nom_allergene;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_allergene() {
		return nom_allergene;
	}

	public void setNom_allergene(String nom_allergene) {
		this.nom_allergene = nom_allergene;
	}

	@Override
	public String toString() {
		return "Allergene [id=" + id + ", nom_allergene=" + nom_allergene + "]";
	}
		

}
