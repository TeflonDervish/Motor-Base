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

    }

    public void onClickSignUp(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginService = new LoginService();
    }
}
