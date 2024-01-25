module com.example.inpcw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.inpcw to javafx.fxml;
    exports com.example.inpcw;
}