package com.devmare.pca2projectjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HandleHomePageController {
    public void handleAdminPage(ActionEvent event) {
        System.out.println("Admin Page button clicked...");
        //! Load the FXML file for adding an account
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/admin-page.fxml"));
        try {
            //! Load the FXML file into a Parent node
            Parent addAccount = fxmlLoader.load();
            //! Create a Scene with the Parent node
            Scene addAccountScene = new Scene(addAccount, 800, 650);

            //! Get the current stage and set the scene to the Add Account scene
            Stage addAccountStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            addAccountStage.setScene(addAccountScene);
            addAccountStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleUserPage(ActionEvent event) {
        System.out.println("Admin Page button clicked...");
        //! Load the FXML file for adding an account
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/user-page.fxml"));
        try {
            //! Load the FXML file into a Parent node
            Parent addAccount = fxmlLoader.load();
            //! Create a Scene with the Parent node
            Scene addAccountScene = new Scene(addAccount, 800, 650);

            //! Get the current stage and set the scene to the Add Account scene
            Stage addAccountStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            addAccountStage.setScene(addAccountScene);
            addAccountStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
