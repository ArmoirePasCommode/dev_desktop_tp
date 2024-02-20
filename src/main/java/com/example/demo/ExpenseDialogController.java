package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class ExpenseDialogController {

    @FXML
    private TextField periodeField;

    @FXML
    private TextField totalField;

    @FXML
    private TextField logementField;

    @FXML
    private TextField nourritureField;

    @FXML
    private TextField sortiesField;

    @FXML
    private TextField voitureTransportField;

    @FXML
    private TextField voyageField;

    @FXML
    private TextField impotsField;

    @FXML
    private TextField autresField;

    @FXML
    private Button validateButton;

    @FXML
    private void initialize() {
        // Add listeners for field validation
        addValidationListeners();
    }

    private void addValidationListeners() {
        // Add listener to enable/disable validate button
        validateButton.disableProperty().bind(
                periodeField.textProperty().isEmpty()
                        .or(totalField.textProperty().isEmpty())
                        .or(logementField.textProperty().isEmpty())
                        .or(nourritureField.textProperty().isEmpty())
                        .or(sortiesField.textProperty().isEmpty())
                        .or(voitureTransportField.textProperty().isEmpty())
                        .or(voyageField.textProperty().isEmpty())
                        .or(impotsField.textProperty().isEmpty())
                        .or(autresField.textProperty().isEmpty())
        );
    }

    @FXML
    private void cancel() {
        // Close the dialog without performing any action
        Stage stage = (Stage) validateButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void validate() {
        // Validate and process the input fields
        if (validateFields()) {
            // Process the fields
            // For example, you can create a new Expense object and perform further actions
            // Then, close the dialog
            Stage stage = (Stage) validateButton.getScene().getWindow();
            stage.close();
        } else {
            // Display an error message indicating invalid input
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de validation");
            alert.setHeaderText("Champs invalides");
            alert.setContentText("Veuillez vérifier le format des champs et assurez-vous qu'ils sont tous renseignés correctement.");
            alert.showAndWait();
        }
    }

    private boolean validateFields() {
        // Implement validation logic for each field
        // For example, you can check if the fields are in the correct format (date + decimals)
        // Here, we'll just check if they are not empty (assuming they are all required)
        return !periodeField.getText().isEmpty()
                && isValidDecimal(totalField.getText())
                && isValidDecimal(logementField.getText())
                && isValidDecimal(nourritureField.getText())
                && isValidDecimal(sortiesField.getText())
                && isValidDecimal(voitureTransportField.getText())
                && isValidDecimal(voyageField.getText())
                && isValidDecimal(impotsField.getText())
                && isValidDecimal(autresField.getText());
    }

    private boolean isValidDecimal(String text) {
        try {
            // Attempt to parse the text as a double
            double value = Double.parseDouble(text);
            // Ensure the value is non-negative
            return value >= 0;
        } catch (NumberFormatException e) {
            // Invalid format
            return false;
        }
    }

}
