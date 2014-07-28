package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Galaxy;

public class GalaxyDAO extends DAO<Galaxy> {
	private GalaxyDAO() {

	}

	private static GalaxyDAO dao = null;

	public static GalaxyDAO getInstance() {
		if (dao == null) {
			dao = new GalaxyDAO();
		}
		return dao;
	}

	public void addGalaxy(int gid, String name, int hp) {
		String sql = "insert into galaxy values(?, ?, ?)";
		executeUpdate(sql, gid, gid, name, hp);
	}
	
	public Galaxy getGalaxy(int gid){
		String sql = "select * from galaxy where GID = ?";
		RowMapper<Galaxy> rm = new RowMapper<Galaxy>() {
			@Override
			public Galaxy mapRow(ResultSet rs) throws SQLException {
				return new Galaxy(rs.getInt("GID"), rs.getString("NAME"), rs.getInt("HP"));
			}
		};
		return getDTO(sql, gid, rm, gid);
	}
	
	public void updateHP(int damage, int gid){
		String sql = "update galaxy set HP = HP - ? where GID = ?";
		executeUpdate(sql, gid, damage, gid);
	}
}
