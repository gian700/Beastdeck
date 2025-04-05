module giancarlo.beastdeck {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;


    
    opens giancarlo.beastdeck to javafx.fxml;
    exports giancarlo.beastdeck;
    exports giancarlo.beastdeck.servicio;
    exports giancarlo.beastdeck.backend.controller;
    exports giancarlo.beastdeck.model;
    opens giancarlo.beastdeck.controller to javafx.fxml;
}