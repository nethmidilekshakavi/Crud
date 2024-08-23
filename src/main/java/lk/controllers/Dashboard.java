package lk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {

    @FXML
    void btnStudent(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/Student.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("StudentFrom");
        stage.show();

    }

    @FXML
    void btnTeacher(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("/view/Teacher.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("TeachersFrom");
        stage.show();

    }

}