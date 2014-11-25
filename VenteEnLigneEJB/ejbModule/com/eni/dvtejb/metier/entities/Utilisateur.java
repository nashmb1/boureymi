package com.eni.dvtejb.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the UTILISATEUR database table.
 * 
 */
@Entity
@SequenceGenerator(name="seqUtilisateur",sequenceName="utilisateur_seq")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "TYPE_UTIL", discriminatorType=DiscriminatorType.STRING, length =1)
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public abstract class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "seqUtilisateur")
	private long utilisateurid;

	private String email;

	private BigDecimal fax;

	private String login;

	private String nom;

	private String password;

	private String prenom;

	private BigDecimal telephone;

	private String titre;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="utilisateur")
	private List<Commande> commandes;

	//bi-directional many-to-one association to Adresse
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ADRESSE_FK")
	private Adresse adresse;

	public Utilisateur() {
	}

	public long getUtilisateurid() {
		return this.utilisateurid;
	}

	public void setUtilisateurid(long utilisateurid) {
		this.utilisateurid = utilisateurid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String emal) {
		this.email = emal;
	}

	public BigDecimal getFax() {
		return this.fax;
	}

	public void setFax(BigDecimal fax) {
		this.fax = fax;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public BigDecimal getTelephone() {
		return this.telephone;
	}

	public void setTelephone(BigDecimal telephone) {
		this.telephone = telephone;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setUtilisateur(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setUtilisateur(null);

		return commande;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}