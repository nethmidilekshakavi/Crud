package lk.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.Repo.TeacherRepo;
import lk.model.TM.TeacherTM;
import lk.model.TeacherModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {

    @FXML
    private TextField addresstxt;

    @FXML
    private TableColumn<?, String> coladdress;

    @FXML
    private TableColumn<?, String> colid;

    @FXML
    private TableColumn<?, String> colname;

    @FXML
    private TableColumn<?, String> coltele;

    @FXML
    private Button delete;

    @FXML
    private TextField idtxt;

    @FXML
    private TextField nametxtx;

    @FXML
    private TableView<TeacherTM> tableStudent;

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

    public void loadValues() throws SQLException {

        ArrayList<TeacherModel> teacherModels = TeacherRepo.getAll();

        ObservableList<TeacherTM> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < teacherModels.size(); i++) {
            TeacherTM all = new TeacherTM(teacherModels.get(i).getTid(), teacherModels.get(i).getName(), teacherModels.get(i).getAddress(), teacherModels.get(i).getPhone());
            observableList.add(all);
            tableStudent.setItems(observableList);
        }
    }

    public void setValues(){
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        coltele.setCellValueFactory(new PropertyValueFactory<>("phone"));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setValues();
        try {
            loadValues();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}