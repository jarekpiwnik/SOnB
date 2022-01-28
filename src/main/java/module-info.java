module com.example.projekt_sonb {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.projekt_sonb to javafx.fxml;
    exports com.example.projekt_sonb;
    exports com.example.projekt_sonb.controls;
    opens com.example.projekt_sonb.controls to javafx.fxml;
    exports com.example.projekt_sonb.other_classes;
    opens com.example.projekt_sonb.other_classes to javafx.fxml;
}