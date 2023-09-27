module com.devmare.pca2projectjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.devmare.pca2projectjavafx.controllers to javafx.fxml;
    opens com.devmare.pca2projectjavafx.database to javafx.fxml;

    exports com.devmare.pca2projectjavafx;
}
