package com.eni.dvtejb.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the COMMANDE database table.
 * 
 */
@Entity
@SequenceGenerator(name="SeqCommande",sequenceName="commande_seq")
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SeqCommande")
	private long commandeid;

	@Column(name="DATE_EXPIRATION_CARTECREDIT")
	private Timestamp dateExpirationCartecredit;

	private Timestamp datecommande;

	@Column(name="NUMERO_CARTECREDIT")
	private String numeroCartecredit;

	@Column(name="TYPE_CARTECREDIT")
	private String typeCartecredit;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="ADRESSE_FK")
	private Adresse adresse;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="UTILISATEUR_FK")
	private Utilisateur utilisateur;

	//bi-directional many-to-many association to Lignecommande
	@ManyToMany(mappedBy="commandes")
	private List<Lignecommande> lignecommandes;

	public Commande() {
	}

	public long getCommandeid() {
		return this.commandeid;
	}

	public void setCommandeid(long commandeid) {
		this.commandeid = commandeid;
	}

	public Timestamp getDateExpirationCartecredit() {
		return this.dateExpirationCartecredit;
	}

	public void setDateExpirationCartecredit(Timestamp dateExpirationCartecredit) {
		this.dateExpirationCartecredit = dateExpirationCartecredit;
	}

	public Timestamp getDatecommande() {
		return this.datecommande;
	}

	public void setDatecommande(Timestamp datecommande) {
		this.datecommande = datecommande;
	}

	public String getNumeroCartecredit() {
		return this.numeroCartecredit;
	}

	public void setNumeroCartecredit(String numeroCartecredi) {
		this.numeroCartecredit = numeroCartecredi;
	}

	public String getTypeCartecredit() {
		return this.typeCartecredit;
	}

	public void setTypeCartecredit(String typeCartecredit) {
		this.typeCartecredit = typeCartecredit;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Lignecommande> getLignecommandes() {
		return this.lignecommandes;
	}

	public void setLignecommandes(List<Lignecommande> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}

}