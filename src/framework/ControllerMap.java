package framework;

import java.util.HashMap;
import java.util.Map;

public class ControllerMap {

	private static Map<String, Controller> controllerMap = new HashMap<String, Controller>();

	public static void addController(String name, Controller controller) {
		controllerMap.put(name, controller);
	}

	public static Controller getController(String name) {
		return controllerMap.get(name);
	}

	public static Map<String, Controller> getControllerMap() {
		return controllerMap;
	}

}
