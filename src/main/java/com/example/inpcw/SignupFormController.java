package com.example.inpcw;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignupFormController {
    public TextField txusername;
    public TextField txtpassword;
    public TextField txtemail;
    public Button btnSignup;

    public void btnSignUpOnAction(ActionEvent actionEvent) {
       String email= txtemail.getText();
       String  password=txtemail.getText();
       String username=txusername.getText();


    }
}
