package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import dto.Ship;

public class ShipDAO extends DAO<Ship> {
	private ShipDAO() {
	}

	private static ShipDAO dao = null;

	public static ShipDAO getInstance() {
		if (dao == null) {
			dao = new ShipDAO();
		}
		return dao;
	}

	public void addShip(int sid, int uid) {
		Random random = new Random();
		String sql = "INSERT INTO ship VALUES(?, ?, ?, ?)";
		executeUpdate(sql, uid, sid, uid, uid % 4, random.nextInt(96) + 5);
	}

	public Ship getShip(int sid) {
		String sql = "SELECT * FROM ship WHERE SID = ?";
		RowMapper<Ship> rm = new RowMapper<Ship>() {
			@Override
			public Ship mapRow(ResultSet rs) throws SQLException {
				return new Ship(rs.getInt("SID"), rs.getInt("UID"), rs.getInt("GID"), rs.getInt("ATK"));
			}
		};
		return getDTO(sql, ((sid - 1) / 10) + 1, rm, sid);
	}
	
	public int getATK(int gid){
		String sql = "SELECT SUM(ATK) FROM ship WHERE GID = ?";
		return getInt(sql, gid, gid);
	}
}
