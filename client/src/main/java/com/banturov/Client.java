package com.banturov;

import com.banturov.stage.sending.StateMessage;

import java.io.*;
import java.net.Socket;

public class Client
{
    private static StateMessage stateMessage;
    private static boolean initStage = true;


    private static void checkPort(String port) throws IOException {
        boolean checkFlag = false;
        while(!checkFlag) {
            try {
                Integer.parseInt(port);
                checkFlag = true;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nCHOOSE ANOTHER PORT");
                BufferedReader inputAnotherPort = new BufferedReader(new InputStreamReader(System.in));
                port = inputAnotherPort.readLine();
            }
        }
    }

    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        System.out.println("Input port number: ");
        BufferedReader inputPort = new BufferedReader(new InputStreamReader(System.in));

        String port = inputPort.readLine();
        checkPort(port);

        Socket outputSocket = new Socket("localhost", Integer.parseInt(port));

        //Try to initialize session, while method finish successful
        while(initStage) {
            try {
                stateMessage.identSession(outputSocket);
                initStage = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
//        ObjectOutputStream outputStream = new ObjectOutputStream(outputSocket.getOutputStream());
//        Message mesOutput = new Message(TypeMessage.INIT_USER,"Jojo" );
//        outputStream.writeObject(mesOutput);
//
//        ObjectInputStream inputData = new ObjectInputStream(outputSocket.getInputStream());
//        Message mesInput = (Message) inputData.readObject();
        //Working method
//        String text = new BufferedReader(
//            new InputStreamReader(inputData, StandardCharsets.UTF_8))
//            .lines()
//            .collect(Collectors.joining("\n"));
//        System.out.println("Server spend message: " + mesInput.Message);

        outputSocket.close();
    }
}
