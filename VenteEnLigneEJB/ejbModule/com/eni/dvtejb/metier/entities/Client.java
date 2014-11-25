package com.eni.dvtejb.metier.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue(value="C")
@NamedQuery(name="Client.findByPrenom",
query=" SELECT c FROM Client c WHERE c.prenom = :lePrenom")
public class Client extends Utilisateur {

}
