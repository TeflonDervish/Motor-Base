module org.example.motorbasejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.net.http;
    requires static lombok;
    requires java.desktop;
    requires com.google.gson;

    opens org.example.motorbasejavafx to javafx.fxml;
    exports org.example.motorbasejavafx;
    exports org.example.motorbasejavafx.controller;
    opens org.example.motorbasejavafx.controller to javafx.fxml;
    exports org.example.motorbasejavafx.enums;
    opens org.example.motorbasejavafx.enums to javafx.fxml;
    opens org.example.motorbasejavafx.model to com.google.gson;
}