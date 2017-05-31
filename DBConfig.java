package app.repository;

/**
 * Created by arch1 on 5/30/17.
 */
public class DBConfig {

    private final String user;
    private final String psswd;
    private final String host;
    private final String bdname;

    public DBConfig() {
        this.user = "root";
        this.psswd = "root";
        this.host = "127.0.0.1";
        this.bdname = "jamm";
    }

    public String getUser() {
        return this.user;
    }

    public String getPsswd() {
        return this.psswd;
    }

    public String getHost() {
        return this.host;
    }

    public String getBdname() {
        return this.bdname;
    }

}
