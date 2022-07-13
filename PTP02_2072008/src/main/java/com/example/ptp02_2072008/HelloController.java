package com.example.ptp02_2072008;

import com.example.ptp02_2072008.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private TableView <Student> tableStudent;
    @FXML
    private TableColumn <Integer, Student> colNrp;
    @FXML
    private TableColumn <String, Student> colNama;
    @FXML
    private TableColumn <Integer, Student> colIpa;
    @FXML
    private TableColumn <String, Student> colIps;
    @FXML
    private TextField nrp;
    @FXML
    private TextField nama;
    @FXML
    private TextField ipa;
    @FXML
    private TextField ips;
    @FXML
    public Button btnAdd;
    @FXML
    public Button btnUp;
    @FXML
    public Button btnDel;

    public ObservableList <Student> sList;
    public int idx;

    public void reset(){
        nrp.clear();
        nama.clear();
        ipa.clear();
        ips.clear();
        btnAdd.setDisable(false);
    }

    public void getSelectedItem(MouseEvent mouseEvent) {
        if (!tableStudent.getSelectionModel().getSelectedCells().isEmpty()) {
            btnAdd.setDisable(true);
            btnUp.setDisable(false);
            btnDel.setDisable(false);
            idx = tableStudent.getSelectionModel().getSelectedIndex();
        }
        nrp.setText(String.valueOf(tableStudent.getSelectionModel().getSelectedItem().getNrp()));
        nama.setText(tableStudent.getSelectionModel().getSelectedItem().getNama());
        ipa.setText(String.valueOf(tableStudent.getSelectionModel().getSelectedItem().getIpa()));
        ips.setText(String.valueOf(tableStudent.getSelectionModel().getSelectedItem().getIps()));
    }

    public void initialize(){
        sList = FXCollections.observableArrayList(
                new Student(1, "Axel", 80, 70),
                new Student(2, "Shira", 88, 75),
                new Student(3, "Sapata", 78, 80),
                new Student(4, "Negara", 60, 90),
                new Student(5, "Nicholas", 90, 85)
        );
        tableStudent.setItems(sList);
        colNrp.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colIpa.setCellValueFactory(new PropertyValueFactory<>("ipa"));
        colIps.setCellValueFactory(new PropertyValueFactory<>("ips"));
    }

    public void addStudent(ActionEvent actionEvent) {
        int sNrp = Integer.parseInt(nrp.getText());
        String sName = nama.getText();
        float sIpa = Float.parseFloat(ipa.getText());
        float sIps = Float.parseFloat(ips.getText());
        sList.add(new Student(sNrp, sName, sIpa, sIps));
        reset();
    }

    public void upStudent(ActionEvent actionEvent) {
        int sNrp = Integer.parseInt(nrp.getText());
        String sName = nama.getText();
        float sIpa = Float.parseFloat(ipa.getText());
        float sIps = Float.parseFloat(ips.getText());
        sList.set(idx, new Student(sNrp, sName, sIpa, sIps));
        reset();
    }

    public void delStudent(ActionEvent actionEvent) {
        int nrpDel = Integer.parseInt(nrp.getText());
        for (Student st: sList) {
            if (nrpDel == st.getNrp()) {
                sList.remove(st);
                break;
            }
        }
        reset();
    }
}