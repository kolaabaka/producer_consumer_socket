package com.banturov;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main( String[] args ) throws IOException {
        ServerSocket server = new ServerSocket(4004);
        System.out.println("AWATING...");
        Socket clientSocket = server.accept();
        BufferedReader inputData = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter outputData = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println("Recived message: " + inputData.read());
        outputData.write("Oh, HELLO THERE");
        outputData.flush();
        System.out.println("CLIENT HAS BEEN CONNECTED");
    }
}
