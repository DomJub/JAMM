package app.repository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Philippe on 18/05/2017.
 */
public abstract class AbstractConnect {

	public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String user = "root";
	private final static String psswd = "";
	private static String dbname = "jamm";
<<<<<<< Updated upstream
	private static String host = "10.1.2.157:3306";
//	private final static String user = "root";
//	private final static String psswd = "root";
//	private static String dbname = "jamm";
//	private static String host = "127.0.0.1";
=======

	private static String host = "127.0.0.1:3306";
>>>>>>> Stashed changes

	static Connection conn;

	public AbstractConnect() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(COM_MYSQL_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			log(e.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbname, user, psswd);
		} catch (SQLException e) {
			log("Connexion failed!");
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

	public static void log(String message) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		System.out.println("[" + formatter.format(new Timestamp(new java.util.Date().getTime())) + "] : " + message);
	}

}
