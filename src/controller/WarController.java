package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalaxyDAO;
import dao.ShipDAO;
import framework.Controller;

public class WarController implements Controller {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GalaxyDAO gd = GalaxyDAO.getInstance();
		ShipDAO sd = ShipDAO.getInstance();
		int turn = 0;
		while (gd.getGalaxy(0).getHp() > 0 && gd.getGalaxy(1).getHp() > 0
				&& gd.getGalaxy(2).getHp() > 0 && gd.getGalaxy(3).getHp() > 0) {

			gd.updateHP(sd.getATK(turn), new Random().nextInt(4));
			if (turn == 4) {
				turn = 0;
			}
			else {
				turn++;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (gd.getGalaxy(i).getHp() <= 0) {
				PrintWriter out = resp.getWriter();
				out.println(i + "번 은하가 멸망했음 ㅠㅠ");
			}
		}
	}
}
