package com.webapp.main.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAO {
    private static Properties prop = new Properties();

    static {
        try {
            prop.load(new FileInputStream("src/com/webapp/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (Post p : getPosts())
            System.out.println(p.toString());
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND");
        }
        return con;
    }

    public static List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement state = con.prepareStatement("SELECT id,txt FROM posts");
             ResultSet res = state.executeQuery()) {

            while(res.next()) {
                int id = res.getInt(1);
                String txt = res.getString(2);
                posts.add(new Post(txt, id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public static void deletePost(int id) {
        try (Connection con = getConnection();
             PreparedStatement state = con.prepareStatement("DELETE FROM posts WHERE id=?")) {
            state.setInt(1, id);
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addPost(String txt) {
        try (Connection con = getConnection();
             PreparedStatement state = con.prepareStatement("INSERT INTO posts(txt) VALUES (?)")) {
            state.setString(1, txt);
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
