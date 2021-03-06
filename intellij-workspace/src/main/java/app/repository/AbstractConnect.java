package app.repository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Philippe on 18/05/2017.
 */
public abstract class AbstractConnect {

    private final static DBConfig conf = new DBConfig();

    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final static String user = conf.getUser();
    private final static String psswd = conf.getPsswd();
    private static String dbname = conf.getBdname();
	private static String host = conf.getHost();

    protected static Connection conn;

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

    public static void log(String message) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        System.out.println("[" + formatter.format(new Timestamp(new java.util.Date().getTime())) + "] : " + message);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

}
