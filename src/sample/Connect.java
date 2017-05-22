package sample;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Created by Philippe on 18/05/2017.
 */
public class Connect {

    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final static String user = "java";
    private final static String psswd = "mdp";
    private String dbname = "tchat";
    private String host = "192.168.23.105:3306";
    Connection conn;


    public Connect() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
            Connection conn = null;

            conn = getConnection();
            closeConnection();
        } catch (ClassNotFoundException e) {
            log(e.getMessage());
        } 
    }

    public Connection getConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbname, user, psswd);
        } catch (SQLException e) {
            log("Connexion failed!");
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
