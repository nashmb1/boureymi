package com.eni.dvtejb.metier.sessions;
import java.io.Serializable;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Remote(PanierCycle.class)
//@CacheConfig(maxSize=15, idleTimeoutSeconds=10 )
public class PanierCycleBean implements PanierCycle, Serializable
{
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="VenteEnLigneModuleEJB")
	EntityManager em;
	private HashMap<String, Integer> panier = new HashMap<String, Integer>();
	public void acheter(String article, int quantite)
	{
		if (panier.containsKey(article))
		{
			int quantiteCourante = panier.get(article);
			quantiteCourante += quantite;
			panier.put(article, quantiteCourante);
		}
		else
		{
			panier.put(article, quantite);
		}
	}
	public HashMap<String, Integer> getContenuPanier()
	{
		return panier;
	}
	@Remove
	public void payer()
	{
		System.out.println("----> A implémenter");
	}
	@PostConstruct
	public void postConstructExemple(){
		System.out.println("----> Dans la methode postConstructExemple");
	}
	@PrePassivate
	public void prePassivateExemple(){
		System.out.println("----> Dans la methode prePassivateExemple");
	}
	@PostActivate
	public void postActivateExemple(){
		System.out.println("----> Dans la methode postActivateExemple");
	}
	@PreDestroy
	public void preDestroyExemple(){
		System.out.println("----> Dans la methode preDestroyExemple");
	}
}