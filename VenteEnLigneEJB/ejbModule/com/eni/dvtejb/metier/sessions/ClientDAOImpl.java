package com.eni.dvtejb.metier.sessions;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.eni.dvtejb.metier.entities.Client;

/**
 * Session Bean implementation class ClientDAOImpl
 */
@Stateless
@LocalBean
public class ClientDAOImpl implements ClientDAO {
	@PersistenceContext(unitName="VenteEnLigneModuleEJB")
	private EntityManager em;
	private Logger log = Logger.getLogger(this.getClass());
	public void save(Client client){
		log.debug("Sauve le client :" + client);
		em.persist(client);
	}
	public void merge(Client client) {
		em.merge(client);
	}
	public List findAll() {
		log.debug("recherche tous les clients");
		return em.createQuery("from Client").getResultList();
	}
	public Client findById(Integer id) {
		return em.find(Client.class, id);
	}
	public List findByNom(String nom){
		log.debug("recherche par nom");
		return em.createQuery("from Client c where c.nom =:nom").setParameter("nom", nom).getResultList();
	}
	public List findByPrenom(String prenom){
		log.debug("recherche par prenom");
		Query q = em.createNamedQuery("Utilisateur.findByPrenom");
		q.setParameter("lePrenom", prenom);
		List<Client> resultatsNamedQuery = q.getResultList();
		return resultatsNamedQuery;
	}
}