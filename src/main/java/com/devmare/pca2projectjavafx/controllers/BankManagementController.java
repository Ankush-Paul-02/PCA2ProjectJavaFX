package com.devmare.pca2projectjavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BankManagementController {

    @FXML   //! Annotation indicating that this method is mapped to an FXML element
    private void handleCreateAccountPage(ActionEvent event) {
        System.out.println("Create Account button clicked...");
        //! Load the FXML file for adding an account
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/add-account.fxml"));
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

    @FXML  //! Annotation indicating that this method is mapped to an FXML element
    private void handleShowAccount(ActionEvent event) {
        System.out.println("Show account button clicked...");
        //! Load the FXML file for adding an account
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/account-details.fxml"));
        try {
            //! Load the FXML file into a Parent node
            Parent showAccount = fxmlLoader.load();
            //! Create a Scene with the Parent node
            Scene showAccountScene = new Scene(showAccount, 800, 650);

            //! Get the current stage and set the scene to the Add Account scene
            Stage showAccountStatge = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            showAccountStatge.setScene(showAccountScene);
            showAccountStatge.show();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @FXML
    private void handleDeleteAccount(ActionEvent event) {
        System.out.println("Delete Account button clicked...");
        //! Load the FXML file for delete an account
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/delete-account.fxml"));
        try {
            //! Load the FXML file into a Parent node
            Parent deleteAccount = fxmlLoader.load();
            //! Create a Scene with the Parent node
            Scene deleteAccountScene = new Scene(deleteAccount, 800, 650);

            //! Get the current stage and set the scene to the Add Account scene
            Stage deleteAccountStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            deleteAccountStage.setScene(deleteAccountScene);
            deleteAccountStage.show();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @FXML
    private void handleDepositAmount(ActionEvent event) {
        System.out.println("Deposit Amount button clicked...");
        //! Load the FXML file for update an account
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/deposit-amount.fxml"));
        try {
            //! Load the FXML file into a Parent node
            Parent updateAccount = fxmlLoader.load();
            //! Create a Scene with the Parent node
            Scene updateAccountScene = new Scene(updateAccount, 800, 650);

            //! Get the current stage and set the scene to the Add Account scene
            Stage updateAccountStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            updateAccountStage.setScene(updateAccountScene);
            updateAccountStage.show();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @FXML
    private void handleWithdrawAmount(ActionEvent event) {
        System.out.println("Withdraw Amount button clicked...");
        //! Load the FXML file for update an account
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/views/withdraw-amount.fxml"));
        try {
            //! Load the FXML file into a Parent node
            Parent updateAccount = fxmlLoader.load();
            //! Create a Scene with the Parent node
            Scene updateAccountScene = new Scene(updateAccount, 800, 650);

            //! Get the current stage and set the scene to the Add Account scene
            Stage updateAccountStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            updateAccountStage.setScene(updateAccountScene);
            updateAccountStage.show();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            // Load the FXML file for the previous page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/devmare/pca2projectjavafx/hello-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 600);

            // Get the current stage and set the scene to the previous page scene
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
