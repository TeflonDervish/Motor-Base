package org.example.motorbasejavafx.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.motorbasejavafx.HelloApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField search;
    @FXML
    private ListView myFavorite;
    @FXML
    private ListView myObyavlation;
    @FXML
    private Label nameLogo;
    @FXML
    private ImageView avatar;



    public void showObyavilation(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/create_obyavlation.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) name.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showPostObyavlation(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/obyavlation.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) name.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(ActionEvent actionEvent) {
    }

    public void logout(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/login.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) name.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
