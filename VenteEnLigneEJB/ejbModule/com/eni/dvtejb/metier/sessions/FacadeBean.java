package com.eni.dvtejb.metier.sessions;
import java.io.Serializable;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Stateless
@Remote (FacadeRemote.class)
public class FacadeBean implements FacadeRemote, Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "VenteEnLigneModuleEJB", type =
			PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
	public boolean findByLoginPwd(String login, String pwd){
		Query query = entityManager.createQuery("SELECT u FROM Utilisateur u WHERE" +" login = ?1 AND password = ?2");
		query.setParameter(1, login);
		query.setParameter(2, pwd);
		int nombre =query.getResultList().size();
		if (nombre == 1 ){
			return true;
		} else {
			return false;
		}
	}
}