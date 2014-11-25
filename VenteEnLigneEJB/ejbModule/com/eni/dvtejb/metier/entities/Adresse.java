package com.eni.dvtejb.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ADRESSE database table.
 * 
 */
@Entity
@SequenceGenerator(name="SeqAdresse", sequenceName="adresse_seq")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="SeqAdresse")
	private long adresseid;

	private BigDecimal codepostal;

	private String departement;

	private BigDecimal numero;

	private String pays;

	private String rue;

	private String ville;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="adresse")
	private List<Commande> commandes;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="adresse")
	private List<Utilisateur> utilisateurs;

	public Adresse() {
	}

	public long getAdresseid() {
		return this.adresseid;
	}

	public void setAdresseid(long adresseid) {
		this.adresseid = adresseid;
	}

	public BigDecimal getCodepostal() {
		return this.codepostal;
	}

	public void setCodepostal(BigDecimal codepostal) {
		this.codepostal = codepostal;
	}

	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public BigDecimal getNumero() {
		return this.numero;
	}

	public void setNumero(BigDecimal numero) {
		this.numero = numero;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setAdresse(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setAdresse(null);

		return commande;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setAdresse(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setAdresse(null);

		return utilisateur;
	}

}