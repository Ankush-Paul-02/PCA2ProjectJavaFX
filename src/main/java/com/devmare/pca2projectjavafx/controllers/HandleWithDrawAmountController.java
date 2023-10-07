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

public class HandleWithDrawAmountController {

    @FXML
    private TextField accountNumberField;

    @FXML
    private TextField securityPinField;

    @FXML
    private TextField withAmountField;

    @FXML
    private Label userDetailsLabel;

    @FXML
    private void goBack(ActionEvent event) {
        try {
            //! Load the FXML file for the main page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/hello-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 650);

            //! Get the current stage and set the scene to the main page scene
            Stage stage = (Stage) securityPinField.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void withdrawMoney(ActionEvent event) {
        String accountNumber = accountNumberField.getText();
        String securityPin = securityPinField.getText();
        String withdrawAmount = withAmountField.getText();

        boolean doesAccountExist = DBOperations.doesAccountExist(accountNumber);

        if (doesAccountExist) {
            //! If both account number,security pin, deposit amount are provided, retrieve the account details and deposit
            if (!accountNumber.isEmpty() && !securityPin.isEmpty() && !withdrawAmount.isEmpty()) {
                try {
                    String balance = DBOperations.getBalanceByAccountNumber(accountNumber, securityPin);
                    if (balance != null) {

                        int currentBalance = Integer.parseInt(balance);
                        if (currentBalance >= Integer.parseInt(withdrawAmount)) {
                            int newBalance = currentBalance - Integer.parseInt(withdrawAmount);
                            DBOperations.updateAccountByAccountNumber(accountNumber, securityPin, Integer.toString(newBalance));
                            userDetailsLabel.setText("----------------------Amount withdrawal successfull----------------------\n------------------------------balance: " + newBalance + "------------------------------");
                        } else {
                            userDetailsLabel.setText("You don't have sufficient balance to withdraw from the account");
                        }
                    } else {
                        userDetailsLabel.setText("Something went wrong!");
                    }
                } catch (Exception e) {
                    userDetailsLabel.setText(e.getMessage());
                }
            } else {
                userDetailsLabel.setText("Please enter both account number and security pin.");
            }
        } else {
            userDetailsLabel.setText("Please enter valid account number and security pin.");
        }
    }

}
