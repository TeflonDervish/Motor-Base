package org.example.motorbasejavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.motorbasejavafx.HelloApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class ObyavlationController implements Initializable {
    @FXML
    private ListView listParametr;
    @FXML
    private DatePicker datePublication;
    @FXML
    private ListView additionalDescription;
    @FXML
    private ListView dataSeller;
    @FXML
    private ImageView imageObyavlation;


    public void showPostObyvlation(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/obyavlation.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) dataSeller.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchObyavlation(ActionEvent actionEvent) {
    }

    public void showObyavilation(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/main_page.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) dataSeller.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/login.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) dataSeller.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void datePublic(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
