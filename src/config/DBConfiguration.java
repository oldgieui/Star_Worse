package config;

import java.io.InputStream;

import framework.ConnectionManager;

public class DBConfiguration extends Configuration {
	public DBConfiguration() {
	}

	public void init() {
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("database.properties");
		loadFile(is);
				
		ConnectionManager cm = new ConnectionManager();
		cm.init(getValue("db.className"), getValue("db.url0"), getValue("db.url1"),
				getValue("db.id"), getValue("db.pwd"));
		System.out.println("cm init called");
	}
}
