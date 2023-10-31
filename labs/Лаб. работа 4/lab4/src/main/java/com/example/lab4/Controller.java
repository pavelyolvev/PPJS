package com.example.lab4;

import com.example.lab4.DB.DBconnection;
import com.example.lab4.DB.Employees;
import com.example.lab4.insert.InsertEmplPopUp;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {

    @FXML
    private Button btnNumsrch, btnSelectAll;

    @FXML
    private TableColumn<Employees, String> tblColCity, tblColManager, tblColName, tblColNum, tblColPay,
            tblColRazdName, tblColRazdNum, tblColRazryad;

    @FXML
    private TextField txtNum;
    @FXML
    private TableView<Employees> tableView;
    @FXML
    void initialize() {
        TableViewsetCellFactory();
        TableViewContextMenu();
    }

    @FXML
    void OnClickAll(ActionEvent event) {
        List<Employees> employees = DBconnection.SelectAllQuery();
        if(!Objects.isNull(employees)){
            tableView.setItems(FXCollections.observableList(employees));
            tableUpdate(tableView);
        } else showAlert(Alert.AlertType.ERROR, "Ошибка подключения к бд");
    }
    @FXML
    void OnClickAddEmpl(ActionEvent event){
        InsertEmplPopUp.start();
    }
    //Добавить подтверждение
    @FXML
    void OnClickDelete(ActionEvent event) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Удаление");
        confirmAlert.setHeaderText("Удалить сотрудника " + tableView.getSelectionModel().getSelectedItem().getName() + " под номером " +
                tableView.getSelectionModel().getSelectedItem().getNum());
        ButtonType okButton = new ButtonType("OK");
        ButtonType cancelButton = new ButtonType("Отмена");
        confirmAlert.getButtonTypes().setAll(okButton, cancelButton);
        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == okButton) {
                deleteEmpl();
            }
        });

    }
    void TableViewsetCellFactory(){
        tblColNum.setCellValueFactory(new PropertyValueFactory<>("Num"));
        tblColName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblColManager.setCellValueFactory(new PropertyValueFactory<>("Manager"));
        tblColPay.setCellValueFactory(new PropertyValueFactory<>("Pay"));
        tblColRazdNum.setCellValueFactory(new PropertyValueFactory<>("Numrazd"));
        tblColRazdName.setCellValueFactory(new PropertyValueFactory<>("Namerazd"));
        tblColCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        tblColRazryad.setCellValueFactory(new PropertyValueFactory<>("Razryad"));
    }

    void TableViewContextMenu(){
        ContextMenu contextMenu = new ContextMenu();
        MenuItem miDel = new MenuItem("Удалить");

        miDel.setOnAction(event -> deleteEmpl());
        contextMenu.getItems().add(miDel);

        tableView.setContextMenu(contextMenu);
    }
    @FXML
    void OnClickSearch(ActionEvent event) {
        try {
            int num = Integer.parseInt(txtNum.getText());
            List<Employees> employees = DBconnection.SelectOnNumQuery(num);
            if(!Objects.isNull(employees)){
                tableView.setItems(FXCollections.observableList(employees));
                tableUpdate(tableView);
            } else showAlert(Alert.AlertType.ERROR, "Ошибка подключения к бд");
        } catch (RuntimeException e){
            showAlert(Alert.AlertType.ERROR, "Введите число для поиска");
        }
    }
    void showAlert(Alert.AlertType alertType, String msg){
        Alert alert = new Alert(alertType, msg);
        alert.showAndWait();
    }
    void tableUpdate(TableView tableView){
        tableView.refresh();
        if(tableView.getItems().isEmpty())
            showAlert(Alert.AlertType.WARNING, "Запрос к базе данных вернул 0 строк");
    }
    void deleteEmpl(){
        int num = tableView.getSelectionModel().getSelectedItem().getNum();
        DBconnection.DeleteOnNumQuery(num);
        tableView.setItems(FXCollections.observableList(DBconnection.SelectAllQuery()));
        tableUpdate(tableView);
    }
}