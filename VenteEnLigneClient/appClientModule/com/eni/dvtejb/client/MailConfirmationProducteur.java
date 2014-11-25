package com.eni.dvtejb.client;
import java.io.FileInputStream;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
public class MailConfirmationProducteur {
	// Set up all the default values
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_DESTINATION = "jms/queue/test";
	private static final String DEFAULT_USERNAME = "nasnas";
	private static final String DEFAULT_PASSWORD = "nasty";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "remote://localhost:4447";

	public static void main(String[] args) throws Exception {


		Properties proprietes = new Properties();
		proprietes.load(new FileInputStream("appClientModule/jndi.properties"));
        Context context = new InitialContext(proprietes);

		/*final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
        env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
        env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));*/
        
		
		/*Properties properties = new Properties();
		

        final Properties properties = new Properties();

        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");

        properties.put(Context.PROVIDER_URL, "remote://localhost:4447");

        properties.put(Context.SECURITY_PRINCIPAL, "nasnas");

        properties.put(Context.SECURITY_CREDENTIALS, "nasty");

        Context context = new InitialContext(properties);
        System.out.println("avant");
        ConnectionFactory cf = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        System.out.println("APRES");*/
		
		// 1: recherche d’une connection factory
		System.out.println("avant");
		TopicConnectionFactory topicFactory = (TopicConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
		
		// 2: création d’une connection JMS
		Connection conn = topicFactory.createConnection("nasnas","nasty");
		System.out.println("APRES");
		// 3: création d’une session
		Session session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
		System.out.println("APRES1");
		// 4: Recherche d’une destination
		Topic topic = (Topic) context.lookup("jms/topic/MailConfirmationMdbTopic");
		System.out.println("APRES2");
		// 5: création d’un producteur de message
		MessageProducer producteur = session.createProducer(topic);
		System.out.println("APRES3");
		// 6: publication d’un message
		TextMessage msg = session.createTextMessage();
		System.out.println("APRES4");
		msg.setText("Mail de confirmation pour le client.");
		producteur.send(msg);
		System.out.println("APRES5");
		producteur.close();
		System.out.println("Message envoyé.");

	}
}