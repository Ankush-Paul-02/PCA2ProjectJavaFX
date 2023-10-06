package com.devmare.pca2projectjavafx.controllers;

import com.devmare.pca2projectjavafx.database.DBOperations;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HandleCreateAccountController {

    @FXML   //! Annotation indicating that this field is mapped to an FXML element
    private TextField usernameField;

    @FXML
    private TextField accountNumberField;

    @FXML
    private TextField balanceField;

    @FXML
    private TextField pinField;

    @FXML
    private void createAccount() {
        //! Retrieve user input from the text fields
        String username = usernameField.getText();
        String accountNumber = accountNumberField.getText();
        String balance = balanceField.getText();
        String securityPin = pinField.getText();

        //! Create an instance of DBOperations and add the account to the database
        if (username == null || accountNumber == null || balance == null || securityPin == null) {
            DBOperations dbOperations = new DBOperations();
            dbOperations.addAccount(username, accountNumber, balance, securityPin);

            System.out.println("User Name: " + username);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
            System.out.println("Security Code: " + securityPin);

            usernameField.clear();
            accountNumberField.clear();
            balanceField.clear();
            pinField.clear();
        } else {
            System.out.println("Please enter all fields...");
        }
    }

    @FXML
    private void goBack() {
        try {
            //! Load the FXML file for the main page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/hello-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 650);

            //! Get the current stage and set the scene to the main page scene
            Stage stage = (Stage) pinField.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
