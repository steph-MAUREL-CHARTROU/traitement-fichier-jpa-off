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
@Table(name = "ALLERGENE")
public class Allergene {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom_allergene")
	private String nomAllergene;

	@ManyToMany
	@JoinTable(name = "TB_PROG_ALLERG", joinColumns = @JoinColumn(name = "ALLERG_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = " id"))

	private List<Produit> produits;

	public Allergene() {

	}

	public Allergene(int id, String nomAllergene, List<Produit> produits) {
		super();
		this.id = id;
		this.nomAllergene = nomAllergene;
		this.produits = produits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAllergene() {
		return nomAllergene;
	}

	public void setNomAllergene(String nomAllergene) {
		this.nomAllergene = nomAllergene;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
