package org.example.motorbasejavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.motorbasejavafx.HelloApplication;
import org.example.motorbasejavafx.enums.Role;
import org.example.motorbasejavafx.service.LoginService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private LoginService loginService;

    @FXML
    private TextField login;
    @FXML
    private TextField password;
    public void onClickLogin(ActionEvent actionEvent) {
        try {
            Role role = loginService.checkPassword(login.getText(), password.getText());

            if (role != Role.NOT_LOGIN){
                // Загружаем первое окно
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/main_page.fxml"));
                //Scene scene = new Scene(fxmlLoader.load());
                Parent firstWindow = loader.load();

                // Получаем текущий Stage
                Stage currentStage = (Stage) login.getScene().getWindow();
                // Устанавливаем новую сцену
                currentStage.setScene(new Scene(firstWindow));
            }else {
                System.out.println("Не получилось авторизоваться и сабина обосралась");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickSignUp(ActionEvent actionEvent) {
        try {
            // Загружаем первое окно
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("forms/singin.fxml"));
            //Scene scene = new Scene(fxmlLoader.load());
            Parent firstWindow = loader.load();

            // Получаем текущий Stage
            Stage currentStage = (Stage) login.getScene().getWindow();
            // Устанавливаем новую сцену
            currentStage.setScene(new Scene(firstWindow));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginService = new LoginService();
    }
}
