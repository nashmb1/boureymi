package com.eni.dvtejb.services.sessions;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.eni.dvtejb.domaine.sessions.DAOGeneriqueLocal;
import com.eni.dvtejb.metier.entities.Adresse;
/**
 * Ce client du DAO session bean DaoGenerique réside dans la couche Services
 */
@Stateless
public class DAOClientBean implements DAOClientLocal {
	@EJB
	private DAOGeneriqueLocal daoGenerique;
	public void ajouterAdresse(Adresse adresse){
		daoGenerique.ajouter(adresse);
	}
	public void chercherAdresse( Long id){
		daoGenerique.chercher(Adresse.class, id);
	}
	@Override
	public void methodeSpecifique() {
		// TODO Auto-generated method stub
	}
}