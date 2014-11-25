package com.eni.dvtejb.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.eni.dvtejb.metier.sessions.CompteurStatefulLocal;
import com.eni.dvtejb.metier.sessions.CompteurStatelessLocal;

@WebServlet("/CompteurServlet")
public class CompteurServlet extends HttpServlet {
	private static final Logger log =
			Logger.getLogger(CompteurServlet.class);
	@EJB
	private CompteurStatefulLocal compteurStatefulBean;
	@EJB
	private CompteurStatelessLocal compteurStatelessBean;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		int compteurStateful = compteurStatefulBean.incrementer();
		int compteurStateless = compteurStatelessBean.incrementer();
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		output.println("<CENTER>");
		output.println("M�thode appel�e : " + request.getMethod() +
				"<BR>");
		output.println("Servlet ClientCompteurServlet ex�cut�e." +
				"<BR>");
		output.println("Le compteur Stateful vaut : " +
				compteurStateful + "<BR>");
		output.println("Le compteur Stateless vaut : " +
				compteurStateless + "<BR>");
	}
}