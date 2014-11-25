package com.eni.dvtejb.metier.sessions;
import java.util.HashMap;

import javax.ejb.Remote;

@Remote
public interface PanierCycle
{
	void acheter(String article, int quantite);
	HashMap<String, Integer> getContenuPanier();
	void payer();
}