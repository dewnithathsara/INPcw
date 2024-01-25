package com.example.inpcw;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    public static AnchorPane pane;

    public static void navigate(Route route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case CHATROOM:
                window.setTitle("CHAT ROOM");
                initUI("chatRoomForm.fxml");
                break;
            case LOGIN:
                window.setTitle("LOGIN");
                initUI("LoginForm.fxml");
                break;
            default:

                System.out.println("Mukuth Natho");
        }
    }

    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/com/example/inpcw/views/" + location)));
    }

}
