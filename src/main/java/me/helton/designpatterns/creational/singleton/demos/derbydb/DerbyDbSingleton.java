package me.helton.designpatterns.creational.singleton.demos.derbydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyDbSingleton {
    private static DerbyDbSingleton instance = null;
    private Connection conn = null;

    private DerbyDbSingleton() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DerbyDbSingleton getInstance() {
        if (instance == null) {
            synchronized (DerbyDbSingleton.class) {
                if (instance == null) {
                    instance = new DerbyDbSingleton();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        if (conn == null) {
            synchronized (DerbyDbSingleton.class) {
                if (conn == null) {
                    String dbUrl = "jdbc:derby:memory:helton/dbsingleton;create=true";
                    try {
                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }
}
