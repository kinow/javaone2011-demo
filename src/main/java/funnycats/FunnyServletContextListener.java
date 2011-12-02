package funnycats;

import java.net.UnknownHostException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import funnycats.lifecycle.MongoDBLifecycle;

public class FunnyServletContextListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(FunnyServletContextListener.class);
	private MongoDBLifecycle db;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		LOGGER.info("The context has left the building...");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		LOGGER.info("*** FunnyCats application ***");
		
		try
		{
			db = new MongoDBLifecycle("localhost", 27017, "funnycats");
		} catch ( UnknownHostException uhe ) {
			throw new RuntimeException( "Failed to start MongoDB: " + uhe.getMessage(), uhe );
		}
	}

}
