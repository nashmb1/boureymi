package com.eni.dvtejb.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the LIGNECOMMANDE database table.
 * 
 */
@Entity
@SequenceGenerator(name="SeqLignecommande",sequenceName="lignecommande_seq")
@NamedQuery(name="Lignecommande.findAll", query="SELECT l FROM Lignecommande l")
public class Lignecommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SeqLignecommande")
	private long lignecommandeid;

	private BigDecimal quantite;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="ATICLE_FK")
	private Article article;

	//bi-directional many-to-many association to Commande
	@ManyToMany
	@JoinTable(
		name="LIGNECOMMANDE_TJ"
		, joinColumns={
			@JoinColumn(name="LIGNECOMMANDE_FK")
			}
		, inverseJoinColumns={
			@JoinColumn(name="COMMANDE_FK")
			}
		)
	private List<Commande> commandes;

	public Lignecommande() {
	}

	public long getLignecommandeid() {
		return this.lignecommandeid;
	}

	public void setLignecommandeid(long lignecommandeid) {
		this.lignecommandeid = lignecommandeid;
	}

	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

}