package com.eni.dvtejb.metier.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-26T22:55:49.630+0200")
@StaticMetamodel(Stock.class)
public class Stock_ {
	public static volatile SingularAttribute<Stock, Long> stockid;
	public static volatile SingularAttribute<Stock, BigDecimal> quantite;
	public static volatile ListAttribute<Stock, Article> articles;
}
