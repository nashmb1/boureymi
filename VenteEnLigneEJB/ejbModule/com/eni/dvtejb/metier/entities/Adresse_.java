package com.eni.dvtejb.metier.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-24T16:46:30.771+0200")
@StaticMetamodel(Adresse.class)
public class Adresse_ {
	public static volatile SingularAttribute<Adresse, Long> adresseid;
	public static volatile SingularAttribute<Adresse, BigDecimal> codepostal;
	public static volatile SingularAttribute<Adresse, String> departement;
	public static volatile SingularAttribute<Adresse, BigDecimal> numero;
	public static volatile SingularAttribute<Adresse, String> pays;
	public static volatile SingularAttribute<Adresse, String> rue;
	public static volatile SingularAttribute<Adresse, String> ville;
	public static volatile ListAttribute<Adresse, Commande> commandes;
	public static volatile ListAttribute<Adresse, Utilisateur> utilisateurs;
}
