package org.example.motorbasejavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.motorbasejavafx.HelloApplication;

public class MainPageController {
    @FXML
    private TextField searchField;
    @FXML
    private ListView checkTop;
    @FXML
    private ComboBox typeCar;
    @FXML
    private ComboBox markCar;
    @FXML
    private ComboBox modelCar;
    @FXML
    private ComboBox colorCar;
    @FXML
    private ComboBox typeBody;
    @FXML
    private CheckBox automatic;
    @FXML
    private CheckBox mechanic;
    @FXML
    private CheckBox variator;
    @FXML
    private CheckBox robot;
    @FXML
    private TextField fromPowers;
    @FXML
    private TextField toPowers;
    @FXML
    private TextField fromVolume;
    @FXML
    private TextField toVolume;
    @FXML
    private CheckBox front;
    @FXML
    private CheckBox rear;
    @FXML
    private CheckBox all;
    @FXML
    private TextField fromRun;
    @FXML
    private TextField toRun;
    @FXML
    private TextField fromPrice;
    @FXML
    private TextField toPrice;
    @FXML
    private TextField yearsCar;

    public void onClickFind(ActionEvent actionEvent) {
    }

    public void showPostObyvlation(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/obyavlation.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) searchField.getScene().getWindow();
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
            Stage currentStage = (Stage) searchField.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showObyavilation(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/main_page.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) searchField.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
