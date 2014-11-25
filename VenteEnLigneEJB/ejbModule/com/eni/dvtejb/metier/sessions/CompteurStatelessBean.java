package com.eni.dvtejb.metier.sessions;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

/**
 * Session Bean implementation class CompteurStatelessBean
 */
@Stateless
@Local(CompteurStatelessLocal.class)
@LocalBean
public class CompteurStatelessBean implements CompteurStatelessLocal{
	private static final Logger log =
			Logger.getLogger(CompteurStatelessBean.class);
	private int compteur = 0;
	public int incrementer() {
		return ++compteur;
	}
	@PostConstruct
	public void raz() {
		compteur = 99;
	}
}