package lk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private TextField PW;

    @FXML
    private TextField UN;

    @FXML
    private Button login;


    @FXML
    void LoginToTheSystem(ActionEvent event) throws IOException {

        String username = "admin";
        String password = "1234";

        if (UN.getText().equals(username) && PW.getText().equals(password)) {

            Parent parent = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("DashBoard");
            stage.show();

            Stage loginstage = (Stage) UN.getScene().getWindow();
            loginstage.close();
        }

    }

}