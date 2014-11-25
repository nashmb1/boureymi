package com.eni.dvtejb.metier.sessions;

import java.util.List;

import javax.ejb.Remote;

import com.eni.dvtejb.metier.entities.Client;

@Remote
public interface ClientDAO {
	public List findAll();
	public List findByNom(String nom);
	public Client findById(Integer id);
	public void save(Client client);
	public void merge(Client client);
	public List findByPrenom(String prenom);
}
