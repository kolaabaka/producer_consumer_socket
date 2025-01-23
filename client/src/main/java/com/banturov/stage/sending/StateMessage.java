package com.banturov.stage.sending;

import com.banturov.dto.Message;
import com.banturov.dto.TypeMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class StateMessage {

    public static void identSession(Socket socket) throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputData = new ObjectInputStream(socket.getInputStream());

        outputStream.writeObject(new Message(TypeMessage.INIT_USER, "Q"));
        Message answer = (Message) inputData.readObject();
        System.out.println(answer.getMessage());

        if(!answer.getType().equals(TypeMessage.OK)){
            throw new SocketException(answer.getMessage());
        }
    }
}
