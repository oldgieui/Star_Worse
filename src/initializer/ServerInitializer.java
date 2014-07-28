package initializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import config.DBConfiguration;
import dao.GalaxyDAO;

public class ServerInitializer implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Map Initialize!!");
		ControllerInitializer ci = new ControllerInitializer();
		ci.init();
		DBConfiguration dbc = new DBConfiguration();
		dbc.init();
		for (int i = 0; i < 4; i++) {
			GalaxyDAO.getInstance().addGalaxy(i, "G"+i, 100000);
		}
	}
}
