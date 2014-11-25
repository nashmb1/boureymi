package com.eni.dvtejb.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ARTICLE database table.
 * 
 */
@Entity
@SequenceGenerator(name="SeqArticle", sequenceName="article_seq")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SeqArticle")
	private long articleid;

	private String nom;

	private double prix;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="PRODUIT_FK")
	private Produit produit;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="STOCK_FK")
	private Stock stock;

	//bi-directional many-to-one association to Lignecommande
	@OneToMany(mappedBy="article")
	private List<Lignecommande> lignecommandes;

	public Article() {
	}

	public long getArticleid() {
		return this.articleid;
	}

	public void setArticleid(long articleid) {
		this.articleid = articleid;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<Lignecommande> getLignecommandes() {
		return this.lignecommandes;
	}

	public void setLignecommandes(List<Lignecommande> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}

	public Lignecommande addLignecommande(Lignecommande lignecommande) {
		getLignecommandes().add(lignecommande);
		lignecommande.setArticle(this);

		return lignecommande;
	}

	public Lignecommande removeLignecommande(Lignecommande lignecommande) {
		getLignecommandes().remove(lignecommande);
		lignecommande.setArticle(null);

		return lignecommande;
	}

}