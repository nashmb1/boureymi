package com.eni.dvtejb.metier.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-24T16:46:30.954+0200")
@StaticMetamodel(Produit.class)
public class Produit_ {
	public static volatile SingularAttribute<Produit, Long> produitid;
	public static volatile SingularAttribute<Produit, String> desciption;
	public static volatile SingularAttribute<Produit, String> nom;
	public static volatile ListAttribute<Produit, Article> articles;
	public static volatile SingularAttribute<Produit, Catalogue> catalogue;
}
