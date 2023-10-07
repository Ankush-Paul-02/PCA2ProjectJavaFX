package com.devmare.pca2projectjavafx.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {

    //! Create a DBConnection instance to establish a database connection
    static DBConnection dbConnection = new DBConnection();

    public void addAccount(String username, String accountNumber, String balance, String securityPin) {

        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            //! // SQL query to insert user details into the database
            String sqlQuery = "INSERT INTO users (USERNAME, ACCOUNT_NUM, BALANCE, SECURITY_CODE) VALUES (?,?,?,?)";

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
            Connection connection = dbConnection.getConnection();

            //! SQL query to select user details based on account number and security pin
            String sqlQuery = "SELECT * FROM users WHERE ACCOUNT_NUM = ? AND SECURITY_CODE = ?";

            //! Prepare a PreparedStatement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, securityPin);

            //! Execute the SQL update statement
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                //! If a user is found, retrieve and format the user details
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

    public static void deleteAccountByAccountNumber(String accountNumber, String securityPin) {
        try {
            Connection connection = dbConnection.getConnection();

            //! SQL query to select user details based on account number and security pin
            String sqlQuery = "DELETE FROM users WHERE ACCOUNT_NUM =? AND SECURITY_CODE =?";

            //! Prepare a PreparedStatement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, securityPin);

            //! Execute the SQL update statement
            preparedStatement.executeUpdate();
            System.out.println("User Account Deleted Successfully...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean doesAccountExist(String accountNumber) {
        try {
            Connection connection = dbConnection.getConnection();

            //! SQL query to check if an account exists based on account number
            String sqlQuery = "SELECT COUNT(*) FROM users WHERE ACCOUNT_NUM = ?";

            //! Prepare a PreparedStatement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, accountNumber);

            //! Execute the SQL query and retrieve the result
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateAccountByAccountNumber(String accountNumber, String securityPin, String balance) {
        try {
            Connection connection = dbConnection.getConnection();
            String sqlQuery = "UPDATE users SET BALANCE =? WHERE ACCOUNT_NUM =? AND SECURITY_CODE =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, balance);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.setString(3, securityPin);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Account balance updated successfully.");
            } else {
                System.out.println("No account found with the provided account number and security pin.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBalanceByAccountNumber(String accountNumber, String securityPin) {
        try {
            //! Create a DBConnection instance to establish a database connection
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();

            //! SQL query to select balance based on account number and security pin
            String sqlQuery = "SELECT BALANCE FROM users WHERE ACCOUNT_NUM = ? AND SECURITY_CODE = ?";

            //! Prepare a PreparedStatement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, securityPin);

            //! Execute the SQL select statement
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                //! If a user is found, retrieve and return the balance
                return resultSet.getString("BALANCE");
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
