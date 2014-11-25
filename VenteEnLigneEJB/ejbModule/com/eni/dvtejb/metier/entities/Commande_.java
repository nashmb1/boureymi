package com.eni.dvtejb.metier.entities;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-09-05T01:38:46.343+0200")
@StaticMetamodel(Commande.class)
public class Commande_ {
	public static volatile SingularAttribute<Commande, Long> commandeid;
	public static volatile SingularAttribute<Commande, Timestamp> dateExpirationCartecredit;
	public static volatile SingularAttribute<Commande, Timestamp> datecommande;
	public static volatile SingularAttribute<Commande, String> numeroCartecredit;
	public static volatile SingularAttribute<Commande, String> typeCartecredit;
	public static volatile SingularAttribute<Commande, Adresse> adresse;
	public static volatile SingularAttribute<Commande, Utilisateur> utilisateur;
	public static volatile ListAttribute<Commande, Lignecommande> lignecommandes;
}
