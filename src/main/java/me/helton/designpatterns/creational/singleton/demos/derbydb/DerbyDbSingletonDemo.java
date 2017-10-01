package me.helton.designpatterns.creational.singleton.demos.derbydb;

import com.google.common.base.Stopwatch;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyDbSingletonDemo {
    public static void main(String[] args) {
        DerbyDbSingleton instance = DerbyDbSingleton.getInstance();

        Stopwatch stopwatch = Stopwatch.createStarted();
        Connection conn = instance.getConnection();
        stopwatch.stop();
        System.out.println("[1] Elapsed time to create a connection: " + stopwatch);

        Statement stmt;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(30), City VARCHAR(20))");
            System.out.println("Table created");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        stopwatch = Stopwatch.createStarted();
        instance.getConnection();
        stopwatch.stop();
        System.out.println("[2] Elapsed time to create a connection: " + stopwatch);

    }
}
