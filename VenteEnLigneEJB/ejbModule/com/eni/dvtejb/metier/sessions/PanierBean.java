package com.eni.dvtejb.metier.sessions;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import com.eni.dvtejb.metier.entities.Article;
import com.eni.dvtejb.metier.entities.Client;
import com.eni.dvtejb.metier.entities.Commande;
import com.eni.dvtejb.metier.entities.Lignecommande;
import com.eni.dvtejb.metier.entities.Utilisateur;

@Stateful
@Remote (PanierBeanRemote.class)
public class PanierBean implements PanierBeanRemote, Serializable {
	private static final Logger log = Logger.getLogger(PanierBean.class.getName());
	@PersistenceContext(unitName="VenteEnLigneModuleEJB")
	EntityManager em;
	private static final long serialVersionUID = 1L;
	private ArrayList<Article> articles;
	// Initialisation de la liste d’articles
	@PostConstruct
	public void creation(){
		articles = new ArrayList<Article>();
	}
	/**
	 * Constructeur par défaut.
	 */
	public PanierBean() {
	}
	public Commande genererCommande(Article[] listArticles, Client
			client, BigDecimal[] quantites) {
		// A chaque article (prix, nom) est associé une ligne decommande (quantite)
		List<Lignecommande> ligneCommandes = new
				ArrayList<Lignecommande> (listArticles.length);
		// entityManager.getTransaction().begin();
		for (int i=0;i<listArticles.length;i++){
			Lignecommande lignecommande = new Lignecommande();
			lignecommande.setArticle(listArticles[i]);
			lignecommande.setQuantite(quantites[i]);
			ligneCommandes.add(lignecommande);
		}
		// Une commande est composée de 1 à N lignes de commande
		Commande commande = new Commande();
		commande.setUtilisateur(client);
		Date aujourdhui = new Date();
		long t = aujourdhui.getTime();
		java.sql.Timestamp aujourdhuiSQL = new java.sql.Timestamp(t);
		commande.setDatecommande( aujourdhuiSQL);
		List<Lignecommande> set = new ArrayList<Lignecommande>();
		set.addAll( ligneCommandes );
		commande.setLignecommandes(set);
		return commande;
	}

	@Resource(mappedName ="jms/RemoteConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName="topic/MailConfirmationMdbTopic")
	private Topic leTopic;

	private void producteurMail(Commande commande){
		log.info("Debut de la méthode producteurMail");
		Connection conn = null;
		Session session = null;
		try {
			conn = connectionFactory.createConnection();
			session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
			MessageProducer producteur = session.createProducer(leTopic);
			ObjectMessage message = session.createObjectMessage();
			message.setObject(commande);
			producteur.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				log.info("Fin de la méthode producteurMail");
				session.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void ajouterArticle(Article article, BigDecimal quantite) {
		// TODO Auto-generated method stub

	}
	@Override
	public Collection<String> getProduits() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Article findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Article> getPanier() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getMontantTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void viderPanier() {
		// TODO Auto-generated method stub

	}
	@Override
	public void supprimerArticle(Article articlePanier) {
		// TODO Auto-generated method stub

	}
	@Override
	public List afficherHistoCommandes(Utilisateur u) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void commander(Client client, ArrayList<Article> articlesPanier,
			String numCC, String typeCC, java.sql.Date expirationDate) {
		// TODO Auto-generated method stub

	}

}