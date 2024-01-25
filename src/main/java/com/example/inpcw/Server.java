package com.example.inpcw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Thread(()-> {
            try {

                ServerSocket serverSocket = new ServerSocket(3000);
                //local socket
                Socket socket = serverSocket.accept();
                System.out.println("Accepted");
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String reply = "";
                String message = "";
                while (!message.equals("End")) {
                    message = dataInputStream.readUTF();

                    reply = bufferedReader.readLine();
                    dataOutputStream.writeUTF(reply);
                    dataOutputStream.flush();
                }
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}