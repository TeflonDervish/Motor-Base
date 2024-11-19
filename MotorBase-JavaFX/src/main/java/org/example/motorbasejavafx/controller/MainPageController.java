package org.example.motorbasejavafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.example.motorbasejavafx.HelloApplication;
import org.example.motorbasejavafx.model.Car;
import org.example.motorbasejavafx.service.CarService;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MainPageController implements Initializable {
    @FXML
    private TextField searchField;
    @FXML
    private ListView<String> checkTop;
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

    private CarService carService;

    public void onClickFind(ActionEvent actionEvent) {
    }

    public void showPostObyvlation(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/create_obyavlation.fxml"));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carService = new CarService();

        ObservableList<String> observableList = FXCollections.observableList(
                carService.getAllCars().stream().map(Car::toString).collect(Collectors.toList())

        );
        checkTop.setItems(observableList);

    }
}
