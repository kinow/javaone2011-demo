package funnycats;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunnyServletContextListener implements ServletContextListener {

	private Configuration configuration = null;
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(FunnyServletContextListener.class);

	public void contextInitialized(ServletContextEvent event) {
		LOGGER.info("*** Starting up FunnyCats application ***");

		try {
			this.configuration = new PropertiesConfiguration("funnycats.properties");
		} catch (ConfigurationException e) {
			//throw new RuntimeException(e);
		}
		
		ServletContext ctx = event.getServletContext();
		String path = ctx.getRealPath(configuration.getString("cats.pictures"));
		File directory = new File(path);

		List<FunnyCat> funnyCats = Utils.getFunnyCats(directory);
		for (FunnyCat funnyCat : funnyCats) {
			CatController.cats.put(funnyCat.getId(), funnyCat);
		}

	}

	public void contextDestroyed(ServletContextEvent event) {
		LOGGER.info("*** Shutting down FunnyCats application ***");
		this.configuration = null;
	}

}
