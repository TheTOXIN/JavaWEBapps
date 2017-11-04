package com.toxin.DateBaseTest;

import java.io.*;
import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb?" +
            "useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USR = "root";
    private final static String PAS = "root";

    public static void main(String[] args) throws IOException {
        Connection con;
        Statement state;
        PreparedStatement prepState;

        try {
            con = DriverManager.getConnection(URL, USR, PAS);
            state = con.createStatement();

            if (!con.isClosed()) {
                System.out.println("CONNECT DATE BASE");
            }

            String sql = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/test.sql"))).readLine();
            state.execute(sql);

            int ans = state.executeUpdate("UPDATE users SET name = 'Kotlin' WHERE id = 4");
            System.out.println("RES = " + ans);

            state.addBatch("INSERT INTO users(name, age, email) VALUES('TMP', 0 , 'TMP')");
            state.addBatch("DELETE FROM users WHERE name = 'TMP'");
            state.executeBatch();

            String prepSQL = "INSERT INTO users VALUES(?,?,?,?)";
            prepState = con.prepareStatement(prepSQL);
            prepState.setInt(1, (int) (Math.random() * 1000));
            prepState.setString(2, "LOL");
            prepState.setInt(3, 0);
            prepState.setString(4, "LOL");
            prepState.execute();

            ResultSet res = state.executeQuery("SELECT * FROM users");
            while (res.next()) {
                System.out.print(res.getInt(1) + " ");
                System.out.print(res.getString(2) + " ");
                System.out.print(res.getInt(3) + " ");
                System.out.println(res.getString(4) + " ");
            }

            con.close();

            if (con.isClosed()) {
                System.out.println("DISCONNECT DATE BASE");
            }
        } catch (SQLException e) {
            System.out.println("DRIVER NOT FOUND");
        }
    }

}
