package com.banturov;

import com.banturov.dto.Message;
import com.banturov.dto.TypeMessage;

import com.banturov.config.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        Configuration config = new Configuration();
        String port = config.properties.getProperty("server.client.port");
        System.out.println("SERVER STARTED");
        System.out.println("SERVER PORT: " + port);
        while(true) {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
            Socket clientSocket = serverSocket.accept();

            ObjectInputStream inputData = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream outputData = new ObjectOutputStream(clientSocket.getOutputStream());
            Message mesInput = (Message) inputData.readObject();
            System.out.println("Recived message: " + mesInput);
            Message mesOutput = new Message(TypeMessage.OK, "Ok, u right");
            outputData.writeObject(mesOutput);
            System.out.println("CLIENT HAS BEEN CONNECTED");

            //Good practice, don`t be wasteful silly programmsit...
            clientSocket.close();
            serverSocket.close();
        }
    }
}
