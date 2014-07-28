package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.RowMapper;

import dto.User;

public class UserDAO extends DAO<User> {
	private UserDAO() {
	}

	private static UserDAO dao = null;

	public static UserDAO getInstance() {
		if (dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}

	public void addUser(int uid) {
		String sql = "INSERT INTO user (UID, GID) VALUES(?, ?)";
		executeUpdate(sql, uid, uid, uid % 4);
	}

	public User getUser(int uid) {
		String sql = "SELECT * FROM user WHERE UID = ?";
		RowMapper<User> rm = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs) throws SQLException {
				return new User(rs.getInt("UID"), rs.getInt("GID"));
			}
		};
		return getDTO(sql, uid, rm, uid);
	}
}
