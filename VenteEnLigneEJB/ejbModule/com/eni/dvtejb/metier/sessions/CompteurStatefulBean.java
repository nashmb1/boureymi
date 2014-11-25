package com.eni.dvtejb.metier.sessions;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import org.jboss.logging.Logger;

@Stateful
@Local(CompteurStatefulLocal.class)
@LocalBean
public class CompteurStatefulBean implements CompteurStatefulLocal {
	private static final Logger log =
			Logger.getLogger(CompteurStatefulBean.class);
	private int compteur = 0;
	public int incrementer() {
		return ++compteur;
	}
	@PostConstruct
	public void raz() {
		compteur = 99;
	}
}