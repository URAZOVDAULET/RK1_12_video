package com.example.demo2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HelloWorldController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView first_image;

    @FXML
    void initialize() {
        assert first_image != null : "fx:id=\"first_image\" was not injected: check your FXML file 'app.fxml'.";

    }

}

