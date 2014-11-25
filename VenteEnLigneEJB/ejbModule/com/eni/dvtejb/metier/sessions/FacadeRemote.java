package com.eni.dvtejb.metier.sessions;

import javax.ejb.Remote;

@Remote
public interface FacadeRemote {
	public boolean findByLoginPwd(String login, String pwd);
}
