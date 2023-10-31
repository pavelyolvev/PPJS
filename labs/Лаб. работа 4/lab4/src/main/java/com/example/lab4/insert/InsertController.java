package com.example.lab4.insert;

import com.example.lab4.DB.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InsertController {
    @FXML
    private TextField txtCity, txtManager, txtName, txtNameRazd, txtNumRazd, txtPay, txtRazryad;
    @FXML
    void OnClickCancel(ActionEvent event) {
        closeWindow();
    }

    @FXML
    void OnClickSave(ActionEvent event) {
        String name;
        int pay;
        int numRazd;
        int razryad;

        try {
            if(!txtName.getText().isEmpty())
                name = txtName.getText();
            else throw new Exception();

            try {
                pay = Integer.parseInt(txtPay.getText());
                numRazd = Integer.parseInt(txtNumRazd.getText());
                razryad = Integer.parseInt(txtRazryad.getText());
                String manager = isEmpty(txtManager.getText());
                String nameRazd = isEmpty(txtNameRazd.getText());
                String city = isEmpty(txtCity.getText());

                DBconnection.InsertQuery(name, manager, pay, numRazd, nameRazd, city, razryad);
                closeWindow();
            }catch(NumberFormatException e){
                new Alert(Alert.AlertType.ERROR, "Поля зарплата, номер подразделения и разряд должны содержать числа").showAndWait();
            }


        } catch (Exception e){
            new Alert(Alert.AlertType.ERROR, "Заполните обязательные поля").showAndWait();
        }

    }

    void closeWindow(){
        Stage stage = (Stage) txtManager.getScene().getWindow();
        stage.close();
    }
    String isEmpty(String str){
        if(str.isEmpty())
            return null;
        else return str;
    }

}
