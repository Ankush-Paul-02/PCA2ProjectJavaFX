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

public class HandleDeleteAccountController {

    @FXML   //! Annotation indicating that this field is mapped to an FXML element
    private TextField accountNumberField;

    @FXML
    private TextField securityPinField;

    @FXML
    private Label userDetailsLabel;

    @FXML
    private void goBack(ActionEvent event) {
        try {
            //! Load the FXML file for the main page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/admin-page.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 650);

            //! Get the current stage and set the scene to the main page scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteAccount(ActionEvent event) {
        //! Get the account number from the text field
        String accountNumber = accountNumberField.getText();
        //! Get the security pin from the text field
        String securityPin = securityPinField.getText();

        //! If both account number and security pin are provided, retrieve the account details
        if (!accountNumber.isEmpty() && !securityPin.isEmpty()) {

            boolean doesAccountExist = DBOperations.doesAccountExist(accountNumber);

            if (doesAccountExist) {
                if (securityPin.length() >= 6) {
                    DBOperations.deleteAccountByAccountNumber(accountNumber, securityPin);
                    userDetailsLabel.setText("User account deleted successfully with account number: " + accountNumber);
                } else {
                    userDetailsLabel.setText("Security code must be at least 6 characters long!");
                }
            } else {
                userDetailsLabel.setText("No user found with the provided account number: " + accountNumber);
            }
            accountNumberField.clear();
            securityPinField.clear();
        } else {
            userDetailsLabel.setText("Please enter valid account number and security pin.");
        }
    }
}
