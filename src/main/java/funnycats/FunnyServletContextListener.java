package funnycats;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunnyServletContextListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FunnyServletContextListener.class);

	public void contextInitialized(ServletContextEvent event) {
		LOGGER.info("*** Starting up FunnyCats application ***");

		ServletContext ctx = event.getServletContext();
		String path = ctx.getRealPath("/resources/cats/");
		File directory = new File(path);

		List<FunnyCat> funnyCats = Utils.getFunnyCats(directory);
		for (FunnyCat funnyCat : funnyCats) {
			CatController.cats.put(funnyCat.getId(), funnyCat);
		}

	}

	public void contextDestroyed(ServletContextEvent event) {
		LOGGER.info("*** Shutting down FunnyCats application ***");
	}

}
