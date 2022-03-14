package com.example.demo2;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnectiong()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;

    }
    public void signUpUser(User user) {
        String insert = "INSERT INTO " +
                Const.USER_TABLE + "(" +
                Const.USERS_NAME + "," +
                Const.USERS_SURNAME + "," +
                Const.USERS_LOGIN + "," +
                Const.USERS_PASS + "," +
                Const.USERS_GENDER + ")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnectiong().prepareStatement(insert);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getSurname());
            prSt.setString(3, user.getLogin());
            prSt.setString(4, user.getPass());
            prSt.setString(5, user.getGender());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " +
                Const.USER_TABLE + " WHERE " +
                Const.USERS_LOGIN + "=? AND " +
                Const.USERS_PASS + "=?";
        try {
            PreparedStatement prSt = getDbConnectiong().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPass());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}
