module com.example.prototype {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires com.dlsc.formsfx;

    opens com.example.prototype to javafx.fxml;
    exports com.example.prototype;
}