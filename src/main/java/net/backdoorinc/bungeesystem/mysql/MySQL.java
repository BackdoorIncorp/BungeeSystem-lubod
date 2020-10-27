package net.backdoorinc.bungeesystem.mysql;

import net.backdoorinc.bungeesystem.util.Logger;
import net.backdoorinc.bungeesystem.util.LoggerEnum;

import java.io.IOException;
import java.sql.*;

public class MySQL {

    private String HOST = "", DATABASE = "", USER = "", PASSWORD = "";
    private final int port = 3306;
    public Connection connection;

    public MySQL(String host ,String database,String user,String password) {
        this.HOST = host;
        this.DATABASE = database;
        this.USER = user;
        this.PASSWORD = password;
    }
    public void connect() {
        if (!isConnected()) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://" + HOST + ":" + port + "/" + DATABASE + "?autoReconnect=true", USER,
                        PASSWORD);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        if (isConnected()) {
            try {
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        if (connection != null) {
            return true;
        }
        return false;
    }

    public void update(String query) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet getResult(String query) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    {

    }


}
