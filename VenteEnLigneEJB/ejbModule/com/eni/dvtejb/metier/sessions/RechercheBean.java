package com.eni.dvtejb.metier.sessions;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.eni.dvtejb.metier.entities.Article;

@Stateless
@Remote (RechercheRemote.class)
public class RechercheBean implements RechercheRemote, Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(RechercheBean.class);
	@PersistenceContext(unitName = "VenteEnLigneModuleEJB", type =
			PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	public List<Article> rechercheArticles(String nomArticle, BigDecimal
			prixMinimum, BigDecimal prixMaximum){
		log.info("Entrée dans la classe : " + getClass().getName());
		log.info("Entrée dans la méthode : rechercheArticles()");
		Query query = null;
		if (nomArticle.equals("Tous")){
			query = entityManager.createNativeQuery("SELECT a.articleid, a.nom, a.prix FROM article a WHERE " +
					" a.prix between ?1 and ?2");
			query.setParameter(1, prixMinimum);
			query.setParameter(2, prixMaximum);
		} else {
			query = entityManager.createNativeQuery("SELECT a.articleid, a.nom, a.prix FROM article a WHERE " +
					" a.nom = ?1 AND a.prix between ?2 and ?3");
			query.setParameter(1, nomArticle);
			query.setParameter(2, prixMinimum);
			query.setParameter(3, prixMaximum);
		}
		List articles = query.getResultList();
		return articles;
	}
	// Méthode utile pour l’autocompletion AJAX sous Struts 2
	public List rechercheNomArticles(){
		log.info("Entrée dans la classe : " + getClass().getName());
		log.info("Entrée dans la méthode : rechercheNomArticles()");
		Query query = entityManager.createNativeQuery("SELECT a.nom FROM article a");
				List nomArticles = query.getResultList();
				return nomArticles;
	}
}
