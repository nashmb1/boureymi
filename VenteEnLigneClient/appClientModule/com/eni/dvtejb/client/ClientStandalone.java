package com.eni.dvtejb.client;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.eni.dvtejb.metier.sessions.PanierCycle;
// Cette classe fonctionne en dehors du container EJB (JBoss)
public class ClientStandalone {
	public static void main(String[] args) throws Exception
	{
		Properties proprietes = new Properties();
		proprietes.load(new FileInputStream("appClientModule/jndi.properties"));
		
		
		/*Properties proprietes = new Properties();
		    proprietes.put(Context.INITIAL_CONTEXT_FACTORY,         
		    "org.jboss.naming.remote.client.InitialContextFactory");
		    proprietes.put(Context.PROVIDER_URL,"remote://localhost:4447");
		    proprietes.put(Context.SECURITY_PRINCIPAL, "nasnas");
		    proprietes.put(Context.SECURITY_CREDENTIALS, "nasty");
		    proprietes.put("jboss.naming.client.ejb.context", true);*/
		    InitialContext ctx = new InitialContext(proprietes);
		PanierCycle panier = (PanierCycle)
				ctx.lookup("ejb:VenteEnLigne/VenteEnLigneEJB/PanierCycleBean!"+PanierCycle.class.getName()+"?stateful");
		System.out.println("===> Achat d’un DVD vierge");
		panier.acheter("DVD", 1);
		System.out.println("===> Autre achat de DVD");
		panier.acheter("DVD", 1);
		System.out.println("===> Achat d’une souris");
		panier.acheter("souris", 1);
		System.out.println("===> Affichage du contenu du panier:");
		HashMap<String, Integer> panierMap = panier.getContenuPanier();
		for (String article : panierMap.keySet())
		{
			System.out.println(panierMap.get(article) + " " + article);
		}
		System.out.println("===> Paiement");
		panier.payer();
		System.out.println("===> Un exception object not found exception est jetée après l’appel de la méthode @Remove payer ");
				try
				{
					panier.getContenuPanier();
				}
				catch (javax.ejb.NoSuchEJBException e)
				{
					System.out.println("===> Exception catchée.");
				}
				System.out.println("===> Création d’une seconde instance de bean pour tester la suppression dû au timeout");
						panier = (PanierCycle)
						ctx.lookup("ejb:VenteEnLigne/VenteEnLigneEJB/PanierCycleBean!"+PanierCycle.class.getName()+"?stateful");
						System.out.println("===> Achat d’un DVD");
						panier.acheter("DVD", 1);
						System.out.println("===> Pause de 30 secondes. C’est aussi 30 secondes d’inactivité.");
								Thread.sleep(30 * 1000);
								try
								{
									System.out.println("===> Achat d’un autre DVD");
									panier.acheter("DVD", 1);
								} catch (javax.ejb.NoSuchEJBException e)
								{
									System.out.println("===> Le bean a été supprimé");
								}
	}
}