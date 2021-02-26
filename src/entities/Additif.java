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
	private String nomAdditif;
	
	@ManyToMany
	@JoinTable(name = " TB_ADDTF_PROD", 
	joinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "ADDTF_ID", referencedColumnName = " id"))

	private List<Additif> additifs;
	

	public Additif() {

	}


	public Additif(int id, String nomAdditif, List<Additif> additifs) {
		super();
		this.id = id;
		this.nomAdditif = nomAdditif;
		this.additifs = additifs;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomAdditif() {
		return nomAdditif;
	}


	public void setNomAdditif(String nomAdditif) {
		this.nomAdditif = nomAdditif;
	}


	public List<Additif> getAdditifs() {
		return additifs;
	}


	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}


	@Override
	public String toString() {
		return "Additif [id=" + id + ", nomAdditif=" + nomAdditif + ", additifs=" + additifs + "]";
	}

	
}
