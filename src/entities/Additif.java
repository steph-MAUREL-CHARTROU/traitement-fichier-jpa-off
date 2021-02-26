package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
public class Additif {

	@Id
	private int id;
	private String nom_additif;

	public Additif() {

	}

	public Additif(int id, String nom_additif) {
		super();
		this.id = id;
		this.nom_additif = nom_additif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_additif() {
		return nom_additif;
	}

	public void setNom_additif(String nom_additif) {
		this.nom_additif = nom_additif;
	}

	@Override
	public String toString() {
		return "Additif [id=" + id + ", nom_additif=" + nom_additif + "]";
	}

}
