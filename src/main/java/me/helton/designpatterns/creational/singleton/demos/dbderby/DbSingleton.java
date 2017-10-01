package me.helton.designpatterns.creational.singleton.demos.dbderby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
    private static DbSingleton instance = null;
    private Connection conn = null;

    private DbSingleton() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbSingleton getInstance() {
        if (instance == null) {
            synchronized (DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        if (conn == null) {
            synchronized (DbSingleton.class) {
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
