package com.example.inpcw;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("localhost", 3000);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String reply = "";
            String message = "";
            while (!message.equals("End")) {
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
                dataInputStream.readUTF();
                System.out.println("Server" + message);
            }
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
