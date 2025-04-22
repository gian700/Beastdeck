module giancarlo.beastdeck {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires java.sql;

    
    opens giancarlo.beastdeck to javafx.fxml;
    exports giancarlo.beastdeck;
    exports giancarlo.beastdeck.servicio;
    exports giancarlo.beastdeck.config;
    exports giancarlo.beastdeck.model.clases;
    exports giancarlo.beastdeck.controller;
    exports giancarlo.beastdeck.controller.abstracta;
    exports giancarlo.beastdeck.model.abstractas;
    exports giancarlo.beastdeck.model.enums;
    exports giancarlo.beastdeck.model.constructores;
    exports giancarlo.beastdeck.model.database;
    opens giancarlo.beastdeck.controller to javafx.fxml;
    opens giancarlo.beastdeck.controller.abstracta to javafx.fxml;
}