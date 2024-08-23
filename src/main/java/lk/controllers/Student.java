package lk.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.Repo.StudentRepo;
import lk.model.StudentModel;
import lk.model.TM.studentTM;

import java.sql.SQLException;
import java.util.ArrayList;

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
    private TableView<studentTM> tableStudent;

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
           new Alert(Alert.AlertType.ERROR,"Student not Deleted").show();
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

    public void loadallvalues() throws SQLException {

        ArrayList<StudentModel> allstudent = StudentRepo.getAll();
        ObservableList<studentTM>observableList= FXCollections.observableArrayList();

        for (int i = 0; i<allstudent.size(); i++){
           /* String id = String.valueOf(allstudent.get(i).getSid());
            String tele = String.valueOf(allstudent.get(i).getPhone());*/

            studentTM studentTM = new studentTM(allstudent.get(i).getSid(),allstudent.get(i).getName(),allstudent.get(i).getAddress(),allstudent.get(i).getPhone());
            observableList.add(studentTM);
            tableStudent.setItems(observableList);

        }


    }

    public void setValues(){
        colid.setCellValueFactory(new PropertyValueFactory<>("SID"));
        colname.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("ADDRESS"));
        coltele.setCellValueFactory(new PropertyValueFactory<>("phone"));

    }


}
