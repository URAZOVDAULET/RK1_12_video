package com.example.demo2;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LoginSigInB;

    @FXML
    private Button LoginSignUpB;

    @FXML
    private TextField login;

    @FXML
    private PasswordField pass;

    @FXML
    void initialize() {
        LoginSigInB.setOnAction(event -> {
            String loginText = login.getText().trim();
            String loginPass = pass.getText().trim();
            if(!loginText.equals("") && !loginPass.equals(""))
                loginUser(loginText, loginPass);
            else
                System.out.println("Login and pass is empty");
        });

        LoginSignUpB.setOnAction(event -> {
            LoginSignUpB.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signUp.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String loginPass) {
        DBHandler dbHandler = new DBHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPass(loginPass);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;
        try {
            while(result.next()) {
                counter++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(counter >= 1){
            System.out.println("Вошел");
        }
    }

}
