package lk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.Repo.StudentRepo;
import lk.Repo.TeacherRepo;
import lk.model.TeacherModel;

import java.sql.SQLException;

public class Teacher {

    @FXML
    private TextField addresstxt;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> coltele;

    @FXML
    private Button delete;

    @FXML
    private TextField idtxt;

    @FXML
    private TextField nametxtx;

    @FXML
    private TableView<?> tableStudent;

    @FXML
    private TextField teletxt;

    @FXML
    private Button update;

    @FXML
    void delete(ActionEvent event) {
        int id = Integer.parseInt(idtxt.getText());

        boolean d =  TeacherRepo.deleteTeacher(String.valueOf(id));

        if (d){

            new Alert(Alert.AlertType.CONFIRMATION,"Teacher Deleted").show();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Teacher not Deleted").show();
        }
    }

    @FXML
    void save(ActionEvent event) throws SQLException {

        int id = Integer.parseInt(idtxt.getText());
        String name = nametxtx.getText();
        String address = addresstxt.getText();
        int phone = Integer.parseInt(teletxt.getText());

        TeacherModel teacherModel = new TeacherModel(id,name,address,phone);

        boolean s = TeacherRepo.saveTeacher(teacherModel);

        if (s){
            new Alert(Alert.AlertType.CONFIRMATION,"Teacher Save Successes").show();
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Teacher Save not Successes").show();
        }
    }

    @FXML
    void update(ActionEvent event) throws SQLException {

        String name = nametxtx.getText();
        String address = addresstxt.getText();
        int phone = Integer.parseInt(teletxt.getText());
        int id = Integer.parseInt(idtxt.getText());


        TeacherModel teacherModel = new TeacherModel(id,name,address,phone);
        boolean u = TeacherRepo.updateStudent(teacherModel);

        if (u){
            new Alert(Alert.AlertType.CONFIRMATION,"update Success").show();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"update not success").show();
        }

    }

}