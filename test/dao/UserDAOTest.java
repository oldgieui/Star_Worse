package dao;

import static org.junit.Assert.*;

import org.junit.Test;
import dao.UserDAO;

public class UserDAOTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void addUser(){
		UserDAO.getInstance().addUser(0);
	}
	
	@Test
	public void getUser(){
		assertNotNull(UserDAO.getInstance().getUser(0));
	}

}
