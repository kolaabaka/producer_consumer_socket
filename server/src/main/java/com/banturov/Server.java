package com.banturov;

import com.banturov.dto.Message;
import com.banturov.dto.TypeMessage;

import com.banturov.config.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private static String port;

    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        Configuration config = new Configuration();
        if(args.length == 0) {
            port = config.properties.getProperty("server.client.port");
            System.out.println("SERVER STARTED");
            System.out.println("SERVER PORT: " + port);
        } else {
            port = args[0];
        }
        while(true) {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
            Socket clientSocket = serverSocket.accept();
            clientSocket.getInetAddress().getAddress();

            ObjectInputStream inputData = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream outputData = new ObjectOutputStream(clientSocket.getOutputStream());
            Message mesInput = (Message) inputData.readObject();
            if(mesInput.getMessage().equals("Q")){
                System.exit(1);
            }
            System.out.println("Recived message: " + mesInput + " \n" + clientSocket.getInetAddress().getHostAddress());
            Message mesOutput = new Message(TypeMessage.OK, mesInput.hashCode() + "");
            outputData.writeObject(mesOutput);
            System.out.println("CLIENT HAS BEEN CONNECTED");

            //Good practice, don`t be wasteful silly programmsit...
            clientSocket.close();
            serverSocket.close();
        }
    }
}
