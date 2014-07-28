package framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}
