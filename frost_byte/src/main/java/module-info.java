module com.frost_byte{
    
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    

    opens com.frost_byte to javafx.fxml;
    exports com.frost_byte;
}
