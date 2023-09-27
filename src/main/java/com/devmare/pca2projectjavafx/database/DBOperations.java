package com.devmare.pca2projectjavafx.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {

    public void addAccount(String username, String accountNumber, String balance, String securityPin) {

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            String sqlQuery = "INSERT INTO user_deatails (USERNAME, ACCOUNT_NUM, BALANCE, SECURITY_CODE) VALUES (?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.setString(3, balance);
            preparedStatement.setString(4, securityPin);

            preparedStatement.executeUpdate();
            System.out.println("User Account Created Successfully...");
        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static String getAccountByAccountNumber(String accountNumber, String securityPin) {
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            String sqlQuery = "SELECT * FROM user_deatails WHERE ACCOUNT_NUM = ? AND SECURITY_CODE = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, securityPin);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String balance = resultSet.getString("BALANCE");

                return "---------------User Details---------------\n" + "User Name: " + username + "\nAccount Number: " + accountNumber + "\nBalance: ₹" + balance;
            } else {
                return "No user found with the provided account number and security pin.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
