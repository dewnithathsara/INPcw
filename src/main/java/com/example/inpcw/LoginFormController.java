package com.example.inpcw;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane pane;
    public PasswordField txtPassword;
    public TextField txtusername;
    public Button butnlogin;

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.CHATROOM, pane);

    }
}
