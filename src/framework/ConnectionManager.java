package framework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionManager {

	private static Stack<Connection> connectionPool0 = new Stack<Connection>();
	private static Stack<Connection> connectionPool1 = new Stack<Connection>();

	private String driverClassName = null;
	private String databaseUrl0 = null;
	private String databaseUrl1 = null;
	private String databaseID = null;
	private String databasePW = null;

	// test case로 작동 확인을 빠르게 하기 위해서 넣어둔 값임. 실제 서버로 작동할 때는 null로 초기화해도 됨.

	public void init(String cls, String db0, String db1, String id, String pw) {
		driverClassName = cls;
		databaseUrl0 = db0;
		databaseUrl1 = db1;
		databaseID = id;
		databasePW = pw;
		addConnections();
	}

	private void addConnections() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Error : " + e);
		}
		try {
			for (int i = 0; i < 10; i++) {
				connectionPool0.push(DriverManager.getConnection(databaseUrl0,
						databaseID, databasePW));
				connectionPool1.push(DriverManager.getConnection(databaseUrl1,
						databaseID, databasePW));
			}
			System.out.println("connection0 Pool Size : "
					+ connectionPool0.size());
			System.out.println("connection1 Pool Size : "
					+ connectionPool1.size());
			System.out.println("cp0 url is : " + connectionPool0.get(0).getMetaData().getURL());
			System.out.println("cp1 url is : " + connectionPool1.get(0).getMetaData().getURL());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection(int uid) {
		Connection conn = null;
		switch (uid % 2) {
		case 0:
			conn = connectionPool0.pop();
			System.out.println("connection0 popped : " + connectionPool0.size()
					+ " remains");
			break;
		case 1:
			conn = connectionPool1.pop();
			System.out.println("connection1 popped : " + connectionPool1.size()
					+ " remains");
			break;
		default:
			break;
		}
		return conn;
	}

	public static void returnConnection(Connection conn) {
		try {
			System.out.println("connection url : "
					+ conn.getMetaData().getURL());
			if (conn.getMetaData().getURL()
					.equals("jdbc:mysql://10.73.45.60/yoda")) {
				connectionPool0.push(conn);
			} else if (conn.getMetaData().getURL()
					.equals("jdbc:mysql://10.73.45.61/yoda")) {
				connectionPool1.push(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
