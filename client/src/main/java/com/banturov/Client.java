package com.banturov;

import org.springframework.util.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public class Client
{

    private static String port;

    private static boolean checkPort(String port){
        try{
            Integer.parseInt(port);
            return false;
        } catch(Exception e){
            return true;
        }
    }

    public static void main( String[] args ) throws IOException, InterruptedException {
        System.out.println("Input port number: ");
        BufferedReader inputPort = new BufferedReader(new InputStreamReader(System.in));
        do {
            port = inputPort.readLine();
        } while(checkPort(port));

        Socket outputSocket = new Socket("localhost", Integer.parseInt(port));
        OutputStream outputStream = outputSocket.getOutputStream();
        outputStream.write("HI".getBytes());

        BufferedReader inputData = new BufferedReader(new InputStreamReader(outputSocket.getInputStream()));

        System.out.println("Server spend message: " + inputData.read());

        outputSocket.close();
    }
}
