module com.example.lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.lab4 to javafx.fxml;
    exports com.example.lab4;
    exports com.example.lab4.insert;
    opens com.example.lab4.insert to javafx.fxml;
    exports com.example.lab4.DB;
    opens com.example.lab4.DB to javafx.fxml;
}