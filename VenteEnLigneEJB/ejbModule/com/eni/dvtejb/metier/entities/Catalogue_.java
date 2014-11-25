package com.eni.dvtejb.metier.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-24T16:46:30.854+0200")
@StaticMetamodel(Catalogue.class)
public class Catalogue_ {
	public static volatile SingularAttribute<Catalogue, Long> catalogueid;
	public static volatile SingularAttribute<Catalogue, String> desciption;
	public static volatile SingularAttribute<Catalogue, String> nom;
	public static volatile ListAttribute<Catalogue, Produit> produits;
}
