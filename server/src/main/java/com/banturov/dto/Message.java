package com.banturov.dto;

import java.io.Serializable;

public class Message implements Serializable {
    public TypeMessage Type;
    public String Message;

    public Message(TypeMessage type, String message){
        this.Type = type;
        this.Message = message;
    }

    @Override
    public String toString() {
        return "Type " + Type + " Message " + Message;
    }
}
