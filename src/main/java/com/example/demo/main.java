package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("expense_manager.fxml"));
        Parent root = fxmlLoader.load();

        // Charger le fichier CSS
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());


        stage.setScene(scene);
        stage.setTitle("Gestion des dépenses");

        // Charger une icône pour la fenêtre
        Image icon = new Image(main.class.getResourceAsStream("icon.png"));
        stage.getIcons().add(icon);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
