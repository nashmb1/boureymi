package com.eni.dvtejb.metier.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-24T16:46:30.836+0200")
@StaticMetamodel(Article.class)
public class Article_ {
	public static volatile SingularAttribute<Article, Long> articleid;
	public static volatile SingularAttribute<Article, String> nom;
	public static volatile SingularAttribute<Article, Double> prix;
	public static volatile SingularAttribute<Article, Produit> produit;
	public static volatile SingularAttribute<Article, Stock> stock;
	public static volatile ListAttribute<Article, Lignecommande> lignecommandes;
}
