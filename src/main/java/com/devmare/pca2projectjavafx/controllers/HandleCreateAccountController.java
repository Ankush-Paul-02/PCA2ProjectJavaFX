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

    @FXML
    private TextField usernameField;

    @FXML
    private TextField accountNumberField;

    @FXML
    private TextField balanceField;

    @FXML
    private TextField pinField;

    @FXML
    private void createAccount() {
        String username = usernameField.getText();
        String accountNumber = accountNumberField.getText();
        String balance = balanceField.getText();
        String securityPin = pinField.getText();

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
    }

    @FXML
    private void goBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/hello-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 650);

            Stage stage = (Stage) pinField.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
