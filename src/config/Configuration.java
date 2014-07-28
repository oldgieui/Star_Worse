package config;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Properties;

public abstract class Configuration {
	protected Properties props = null;

	public abstract void init();

	protected void loadFile(InputStream is) {
		try {
			props = new Properties();
			props.load(new BufferedInputStream(is));
			is.close();
		} catch (Exception e) {
			System.err
					.println("load properties file error : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public Properties getProperty() {
		return props;
	}

	public String getValue(String key) {
		String value = null;
		try {
			value = props.getProperty(key, "Not in property file.");
		} catch (Exception e) {
			System.out.println("getPropertyValue error : " + e.getMessage());
			e.printStackTrace();
		}
		return value;
	}
}
