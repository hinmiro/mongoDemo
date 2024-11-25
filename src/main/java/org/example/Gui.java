package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {
    private Button addButton;
    private Button deleteButton;
    private Button readButton;
    private Button updateButton;
    private Label idLabel;
    private Label nameLabel;
    private Label ageLabel;
    private Label cityLabel;
    private Label userLabel;
    private Pane stackPane;
    private TextField idField;
    private TextField nameField;
    private TextField ageField;
    private TextField cityField;
    private VBox vBox;
    private HBox hBox;
    private SoftwareModel app;
    private VBox buttonContainer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        app = new SoftwareModel();
        addButton = new Button("Add");
        deleteButton = new Button("Delete");
        readButton = new Button("Read");
        updateButton = new Button("Update");
        idLabel = new Label("ID:");
        nameLabel = new Label("Name:");
        ageLabel = new Label("Age:");
        cityLabel = new Label("City:");
        userLabel = new Label();
        idField = new TextField();
        nameField = new TextField();
        ageField = new TextField();
        cityField = new TextField();
        stackPane = new Pane();
        addButton.setOnAction(e -> handleAdd(e, idField.getText(), nameField.getText(), ageField.getText(), cityField.getText()));
        deleteButton.setOnAction(e -> handleDelete(e, idField.getText()));
        updateButton.setOnAction(e -> handleUpdate(e, idField.getText(), nameField.getText(), ageField.getText(), cityField.getText()));
        readButton.setOnAction(e -> handleRead(e, idField.getText()));
        vBox = new VBox();
        hBox = new HBox();
        buttonContainer = new VBox();
        hBox.getChildren().addAll(idLabel, idField, nameLabel, nameField, ageLabel, ageField, cityLabel, cityField);
        buttonContainer.getChildren().addAll(addButton, deleteButton, readButton, updateButton);
        vBox.getChildren().addAll(hBox, buttonContainer, userLabel);
        stackPane.getChildren().add(vBox);

        Scene scene = new Scene(stackPane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Application");
        primaryStage.show();
    }

    private void handleAdd(ActionEvent e, String id, String name, String age, String city) {
        app.add(id, name, age, city);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Document added.");
        alert.show();
    }

    private void handleDelete(ActionEvent e, String id) {
        app.delete(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Document deleted.");
        alert.show();
    }

    private void handleUpdate(ActionEvent e, String id, String name, String age, String city) {
        app.update(id, name, age, city);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Document updated.");
        alert.show();
    }

    private void handleRead(ActionEvent e, String id) {
        app.read(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Document read.");
        alert.show();
        userLabel.setText(app.read(id));
    }

}
