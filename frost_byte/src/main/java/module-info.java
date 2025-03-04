module com.frost_byte{
    
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;
    //requires org.jfugue;
    requires java.desktop;

    opens com.frost_byte to javafx.fxml;
    exports com.frost_byte;
}
