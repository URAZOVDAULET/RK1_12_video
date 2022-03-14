package com.example.demo2;

import java.net.URL;
import java.sql.DatabaseMetaData;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginSignUpBatten;

    @FXML
    private CheckBox checkbox_female;

    @FXML
    private CheckBox checkbox_male;

    @FXML
    private TextField login;

    @FXML
    private TextField name;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField surname;

    @FXML
    void initialize() {
        LoginSignUpBatten.setOnAction(event -> {

            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DBHandler dbHandler = new DBHandler();
        String name1 = name.getText();
        String surname1 = surname.getText();
        String login1 = login.getText();
        String pass1 = pass.getText();
        String gender1 = "";
        if(checkbox_male.isSelected())
            gender1 = "Male";
        else
            gender1 = "Female";

        User user = new User(name1, surname1, login1, pass1, gender1);

        dbHandler.signUpUser(user);
    }

}

