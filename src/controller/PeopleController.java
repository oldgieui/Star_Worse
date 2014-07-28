package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShipDAO;
import dao.UserDAO;
import framework.Controller;

public class PeopleController implements Controller {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		for (int i = 1; i <= 100; i++) {
			UserDAO.getInstance().addUser(i);
			for (int j = (i-1) * 10 + 1; j <= i * 10; j++) {
				ShipDAO.getInstance().addShip(j, i);
			}
		}
		System.out.println("백 개 다 찍음");
		HttpSession session = req.getSession();
		session.setAttribute("isBorn", 1);
		resp.sendRedirect("/");
	}
}
