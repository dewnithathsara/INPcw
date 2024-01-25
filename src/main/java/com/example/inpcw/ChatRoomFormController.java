package com.example.inpcw;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatRoomFormController {
    public AnchorPane pane;
    public TextArea txtArea;
    public TextField txtfield;
    public Button btnsend;
    ServerSocket serverSocket;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String message="";
    public void initialize(){
        new Thread(()->{
            try{
                socket = new Socket("localhost" ,3000);
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream=new DataInputStream(socket.getInputStream());
                //txtArea.appendText("connected");
                String reply="";
                // String message="";
                while(!message.equals("exit")){
                    // dataOutputStream.writeUTF(reply);
                    message=  dataInputStream.readUTF();
                    txtArea.appendText("\nserver  :  "+ message);
                }
                dataInputStream.close();
                dataOutputStream.close();

            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtfield.getText());

        dataOutputStream.flush();
    }
}
