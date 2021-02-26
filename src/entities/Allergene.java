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
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name="ALLERGENE")
public class Allergene {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="nom_allergene")
	private String nom_allergene;
	
	@ManyToMany
	@JoinTable(name = "TB_ALLERG_PROD", 
	joinColumns = @JoinColumn(name = "ALLERG_ID", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = " id"))

	private List<Produit> produits;
	

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
