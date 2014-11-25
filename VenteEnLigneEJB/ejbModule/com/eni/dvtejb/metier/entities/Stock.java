package com.eni.dvtejb.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the STOCK database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long stockid;

	private BigDecimal quantite;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="stock")
	private List<Article> articles;

	public Stock() {
	}

	public long getStockid() {
		return this.stockid;
	}

	public void setStockid(long stockid) {
		this.stockid = stockid;
	}

	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setStock(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setStock(null);

		return article;
	}

}