package com.eni.dvtejb.metier.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-24T16:46:30.934+0200")
@StaticMetamodel(Lignecommande.class)
public class Lignecommande_ {
	public static volatile SingularAttribute<Lignecommande, Long> lignecommandeid;
	public static volatile SingularAttribute<Lignecommande, BigDecimal> quantite;
	public static volatile SingularAttribute<Lignecommande, Article> article;
	public static volatile ListAttribute<Lignecommande, Commande> commandes;
}
