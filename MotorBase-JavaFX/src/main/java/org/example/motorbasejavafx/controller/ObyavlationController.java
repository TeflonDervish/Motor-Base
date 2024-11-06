package org.example.motorbasejavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ObyavlationController implements Initializable {



    @FXML
    private TextField name;
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
    }

    public void searchObyavlation(ActionEvent actionEvent) {
    }

    public void showObyavilation(ActionEvent actionEvent) {
    }

    public void logout(ActionEvent actionEvent) {
    }

    public void datePublic(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText("Гибоз");
    }
}
