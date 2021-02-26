package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
public class Produit {
	
	@Id
	private int id;
	@Column( name = " nom_produit")
	private String nom_produit;
	
	@Column( name = "nutritionGradeFr")
	private String nutritionGradeFr_produit;
	
	@Column( name = "energie100gr")
	private Double energie100gr_produit;
	
	@Column( name = "sel100gr")
	private Double sel100gr_produit;
	
	@Column( name = "graisse100gr")
	private Double graisse100gr_produit;
	
	@Column( name = "sucres100gr")
	private Double sucres100gr_produit;
	
	@Column( name = " nom_produit")
	private Double protein100gr_produit;
	
	@Column( name = "fibres100gr")
	private Double fibres100gr_produit;
	
	
	public Produit() {
		
	}


	public Produit(int id, String nom_produit, String nutritionGradeFr_produit, Double energie100gr_produit,
			Double sel100gr_produit, Double graisse100gr_produit, Double sucres100gr_produit,
			Double protein100gr_produit, Double fibres100gr_produit) {
		super();
		this.id = id;
		this.nom_produit = nom_produit;
		this.nutritionGradeFr_produit = nutritionGradeFr_produit;
		this.energie100gr_produit = energie100gr_produit;
		this.sel100gr_produit = sel100gr_produit;
		this.graisse100gr_produit = graisse100gr_produit;
		this.sucres100gr_produit = sucres100gr_produit;
		this.protein100gr_produit = protein100gr_produit;
		this.fibres100gr_produit = fibres100gr_produit;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom_produit() {
		return nom_produit;
	}


	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}


	public String getNutritionGradeFr_produit() {
		return nutritionGradeFr_produit;
	}


	public void setNutritionGradeFr_produit(String nutritionGradeFr_produit) {
		this.nutritionGradeFr_produit = nutritionGradeFr_produit;
	}


	public Double getEnergie100gr_produit() {
		return energie100gr_produit;
	}


	public void setEnergie100gr_produit(Double energie100gr_produit) {
		this.energie100gr_produit = energie100gr_produit;
	}


	public Double getSel100gr_produit() {
		return sel100gr_produit;
	}


	public void setSel100gr_produit(Double sel100gr_produit) {
		this.sel100gr_produit = sel100gr_produit;
	}


	public Double getGraisse100gr_produit() {
		return graisse100gr_produit;
	}


	public void setGraisse100gr_produit(Double graisse100gr_produit) {
		this.graisse100gr_produit = graisse100gr_produit;
	}


	public Double getSucres100gr_produit() {
		return sucres100gr_produit;
	}


	public void setSucres100gr_produit(Double sucres100gr_produit) {
		this.sucres100gr_produit = sucres100gr_produit;
	}


	public Double getProtein100gr_produit() {
		return protein100gr_produit;
	}


	public void setProtein100gr_produit(Double protein100gr_produit) {
		this.protein100gr_produit = protein100gr_produit;
	}


	public Double getFibres100gr_produit() {
		return fibres100gr_produit;
	}


	public void setFibres100gr_produit(Double fibres100gr_produit) {
		this.fibres100gr_produit = fibres100gr_produit;
	}


	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom_produit=" + nom_produit + ", nutritionGradeFr_produit="
				+ nutritionGradeFr_produit + ", energie100gr_produit=" + energie100gr_produit + ", sel100gr_produit="
				+ sel100gr_produit + ", graisse100gr_produit=" + graisse100gr_produit + ", sucres100gr_produit="
				+ sucres100gr_produit + ", protein100gr_produit=" + protein100gr_produit + ", fibres100gr_produit="
				+ fibres100gr_produit + "]";
	}

	
	
}
