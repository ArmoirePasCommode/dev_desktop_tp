package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;


public class ExpenseController {
    @FXML
    private TableView<Expense> expenseTable;

    @FXML
    private TableColumn<Expense, String> periodeColumn;

    @FXML
    private TableColumn<Expense, Double> totalColumn;

    @FXML
    private TableColumn<Expense, Double> logementColumn;

    @FXML
    private TableColumn<Expense, Double> nourritureColumn;

    @FXML
    private TableColumn<Expense, Double> sortiesColumn;

    @FXML
    private TableColumn<Expense, Double> voitureTransportColumn;

    @FXML
    private TableColumn<Expense, Double> voyageColumn;

    @FXML
    private TableColumn<Expense, Double> impotsColumn;

    @FXML
    private TableColumn<Expense, Double> autresColumn;

    public Button clickButton;

    public void initialize() {
        // Add sample expenses
        expenseTable.getItems().addAll(
                new Expense("Janvier", 1000.0, 300.0, 200.0, 100.0, 100.0, 50.0, 150.0, 100.0),
                new Expense("Février", 1200.0, 400.0, 250.0, 150.0, 120.0, 70.0, 180.0, 130.0)
        );

        Scene scene = clickButton.getScene();
        if (scene != null) {
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        }
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        this.showExpenseDialog();
    }
    @FXML
    private void showExpenseDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("expense_dialog.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage for the dialog
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajouter une dépense");
            dialogStage.initModality(Modality.APPLICATION_MODAL);

            // Set the scene with the loaded FXML root
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);

            // Show the dialog
            dialogStage.showAndWait(); // This will wait until the dialog is closed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
