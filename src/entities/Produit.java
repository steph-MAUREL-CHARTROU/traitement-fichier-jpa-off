package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "PRODUIT")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = " nom_produit")
	private String nomProduit;

	@Column(name = "nutritionGradeFr")
	private String nutritionGradeFrProduit;

	@Column(name = "energie100gr")
	private Double energie100grProduit;

	@Column(name = "sel100gr")
	private Double sel100grProduit;

	@Column(name = "graisse100gr")
	private Double graisse100grProduit;

	@Column(name = "sucres100gr")
	private Double sucres100grProduit;

	@Column(name = "protein100gr")
	private Double protein100grProduit;

	@Column(name = "fibres100gr")
	private Double fibres100grProduit;

	// Relations Conception //

	// ----Produits - additifs-----//

	@ManyToMany
	@JoinTable(name = " TB_PROD_ADDTF", joinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ADDTF_ID", referencedColumnName = " id"))

	private List<Additif> additifs;

	// ----Produits - allergenes-----//

	@ManyToMany
	@JoinTable(name = " TB_PROD_ALLERG", joinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ALLERG_ID", referencedColumnName = " id"))

	private List<Allergene> allergenes;

	// ----Produit - Ingredients-----//

	@ManyToMany
	@JoinTable(name = " TB_PROD_INGRDT", joinColumns = @JoinColumn(name = "PROD_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "INGRDT_ID", referencedColumnName = " id"))

	private List<Ingredient> ingredients = new ArrayList();

	// ----Produits - Categories-----//

	@ManyToOne
	@JoinColumn(name = "CATEGORIE_ID")
	private Categorie categorie;

	// ----Produits - Marque -----//
	@ManyToOne
	@JoinColumn(name = "MARQUE_ID")
	private Marque marque;

	public Produit() {

	}

	public Produit(String nomProduit) {

		this.nomProduit = nomProduit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getNutritionGradeFrProduit() {
		return nutritionGradeFrProduit;
	}

	public void setNutritionGradeFrProduit(String nutritionGradeFrProduit) {
		this.nutritionGradeFrProduit = nutritionGradeFrProduit;
	}

	public Double getEnergie100grProduit() {
		return energie100grProduit;
	}

	public void setEnergie100grProduit(Double energie100grProduit) {
		this.energie100grProduit = energie100grProduit;
	}

	public Double getSel100grProduit() {
		return sel100grProduit;
	}

	public void setSel100grProduit(Double sel100grProduit) {
		this.sel100grProduit = sel100grProduit;
	}

	public Double getGraisse100grProduit() {
		return graisse100grProduit;
	}

	public void setGraisse100grProduit(Double graisse100grProduit) {
		this.graisse100grProduit = graisse100grProduit;
	}

	public Double getSucres100grProduit() {
		return sucres100grProduit;
	}

	public void setSucres100grProduit(Double sucres100grProduit) {
		this.sucres100grProduit = sucres100grProduit;
	}

	public Double getProtein100grProduit() {
		return protein100grProduit;
	}

	public void setProtein100grProduit(Double protein100grProduit) {
		this.protein100grProduit = protein100grProduit;
	}

	public Double getFibres100grProduit() {
		return fibres100grProduit;
	}

	public void setFibres100grProduit(Double fibres100grProduit) {
		this.fibres100grProduit = fibres100grProduit;
	}

	public List<Additif> getAdditifs() {
		return additifs;
	}

	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}

	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nomProduit=" + nomProduit + ", nutritionGradeFrProduit="
				+ nutritionGradeFrProduit + ", energie100grProduit=" + energie100grProduit + ", sel100grProduit="
				+ sel100grProduit + ", graisse100grProduit=" + graisse100grProduit + ", sucres100grProduit="
				+ sucres100grProduit + ", protein100grProduit=" + protein100grProduit + ", fibres100grProduit="
				+ fibres100grProduit + ", additifs=" + additifs + ", allergenes=" + allergenes + ", ingredients="
				+ ingredients + ", categorie=" + categorie + ", marque=" + marque + "]";
	}

	
	

}
