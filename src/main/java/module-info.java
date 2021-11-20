module com.example.projekt_sonb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projekt_sonb to javafx.fxml;
    exports com.example.projekt_sonb;
}