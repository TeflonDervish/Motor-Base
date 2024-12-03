package org.example.motorbasejavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Создание WebView
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        // Загрузка веб-страницы
        webEngine.load("http://localhost:8080/main");

        // Создание макета и добавление WebView
        BorderPane root = new BorderPane();
        root.setCenter(webView);

        // Создание сцены и отображение
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Motor-Base");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
