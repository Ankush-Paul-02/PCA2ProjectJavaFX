package com.devmare.pca2projectjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BankManagementController {

    @FXML
    private void handleCreateAccountPage(ActionEvent event) {
        System.out.println("Create Account button clicked...");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/add-account.fxml"));
        try {
            Parent addAccount = fxmlLoader.load();
            Scene addAccountScene = new Scene(addAccount, 800, 650);

            Stage addAccountStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            addAccountStage.setScene(addAccountScene);
            addAccountStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void handleShowAccount(ActionEvent event) {
        System.out.println("Show account button clicked...");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/show-account.fxml"));
        try {
            Parent showAccount = fxmlLoader.load();
            Scene showAccountScene = new Scene(showAccount, 800, 650);

            Stage showAccountStatge = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            showAccountStatge.setScene(showAccountScene);
            showAccountStatge.show();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
