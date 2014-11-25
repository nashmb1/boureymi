package com.eni.dvtejb.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUIT database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long produitid;

	private String desciption;

	private String nom;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="produit")
	private List<Article> articles;

	//bi-directional many-to-one association to Catalogue
	@ManyToOne
	@JoinColumn(name="CATALOGUE_FK")
	private Catalogue catalogue;

	public Produit() {
	}

	public long getProduitid() {
		return this.produitid;
	}

	public void setProduitid(long produitid) {
		this.produitid = produitid;
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

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setProduit(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setProduit(null);

		return article;
	}

	public Catalogue getCatalogue() {
		return this.catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

}