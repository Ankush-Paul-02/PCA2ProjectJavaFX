package com.devmare.pca2projectjavafx.controllers;

import com.devmare.pca2projectjavafx.database.DBOperations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HandleShowAccountController {

    @FXML
    private TextField accountNumberField;

    @FXML
    private TextField securityPinField;

    @FXML
    private Label userDetailsLabel;

    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/hello-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 650);

            Stage stage = (Stage) securityPinField.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showAccount(ActionEvent event) {
        String accountNumber = accountNumberField.getText();
        String securityPin = securityPinField.getText();

        if (!accountNumber.isEmpty() && !securityPin.isEmpty()) {
            String accountDetails = DBOperations.getAccountByAccountNumber(accountNumber, securityPin);
            userDetailsLabel.setText(accountDetails);
        } else {
            userDetailsLabel.setText("Please enter both account number and security pin.");
        }
    }
}
