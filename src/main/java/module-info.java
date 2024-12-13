
module org.example.devoirdejava {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;
    requires mysql.connector.j;


    opens org.example.devoirdejava to javafx.fxml;
    exports org.example.devoirdejava;
}
