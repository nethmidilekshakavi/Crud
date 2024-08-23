package lk.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.Repo.StudentRepo;
import lk.model.StudentModel;

import java.sql.SQLException;

public class Student {

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
    void studentdelete(ActionEvent event) {

        int id = Integer.parseInt(idtxt.getText());

       boolean d =  StudentRepo.deleteStudent(String.valueOf(id));

       if (d){

           new Alert(Alert.AlertType.CONFIRMATION,"Student Deleted").show();
       }
       else {
           new Alert(Alert.AlertType.ERROR,"Student not deeted").show();
       }

    }

    @FXML
    void studentsave(ActionEvent event) throws SQLException {

        int id = Integer.parseInt(idtxt.getText());
        String nam = nametxtx.getText();
        String address = addresstxt.getText();
        int tele = Integer.parseInt(teletxt.getText());

        StudentModel studentModel = new StudentModel(id,nam,address,tele);
        boolean s = StudentRepo.saveStudent(studentModel);

        if (s){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Save Success").show();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Customer not save").show();

        }
        }



    @FXML
    void studentupdate(ActionEvent event) {

        int id = Integer.parseInt(idtxt.getText());
        String name = nametxtx.getText();
        String address = addresstxt.getText();
        int phone = Integer.parseInt(teletxt.getText());

        StudentModel studentModel = new StudentModel(id,name,address,phone);
        boolean u = StudentRepo.updateStudent(studentModel);

        if (u){

            new Alert(Alert.AlertType.CONFIRMATION,"Student Updated").show();
        }
        else {
            new Alert(Alert.AlertType.ERROR,"Student not Updated").show();
        }


    }

}
