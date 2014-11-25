package com.eni.dvtejb.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATALOGUE database table.
 * 
 */
@Entity
@SequenceGenerator(name="SeqCatalogue", sequenceName="catalogue_seq")
@NamedQuery(name="Catalogue.findAll", query="SELECT c FROM Catalogue c")
public class Catalogue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SeqCatalogue")
	private long catalogueid;

	private String desciption;

	private String nom;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="catalogue")
	private List<Produit> produits;

	public Catalogue() {
	}

	public long getCatalogueid() {
		return this.catalogueid;
	}

	public void setCatalogueid(long catalogueid) {
		this.catalogueid = catalogueid;
	}

	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setCatalogue(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setCatalogue(null);

		return produit;
	}

}