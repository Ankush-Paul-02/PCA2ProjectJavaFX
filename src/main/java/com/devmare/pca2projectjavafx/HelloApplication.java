package com.devmare.pca2projectjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    //! The start method sets up the UI and displays the stage.
    @Override
    public void start(Stage stage) throws IOException {
        /**
         * Create an instance of FXMLLoader and load an FXML file.
         * It translates the FXML file into a corresponding scene graph.
         */
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //! Create a new Scene with the content loaded from FXML
        Scene scene = new Scene(fxmlLoader.load(), 800, 650);
        stage.setTitle("Bank Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /**
         *  It launches the JavaFX application by calling launch(), which in turn calls the start
         *  method to initialize the application.
         */
        launch();
    }
}