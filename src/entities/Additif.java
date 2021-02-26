package entities;

import java.util.List;

import javax.persistence.Column;
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
public class Additif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column( name="nom_additif")
	private String nom_additif;
	
	@ManyToMany
	@JoinTable(name = " TB_PROD_ADDTF", 
	joinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "ADDTF_ID", referencedColumnName = " id"))

	private List<Additif> additifs;
	

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
