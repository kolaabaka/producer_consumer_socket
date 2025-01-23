package com.banturov.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    public TypeMessage type;
    public String message;

    public Message(TypeMessage type, String message){
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Type: " + type + " Message: " + message;
    }

    //Only for make id user-session
    @Override
    public int hashCode() {
        int bufHash = message.length() + (int)message.charAt(0) + (int)message.charAt(message.length() - 1);
        return bufHash * 34;
    }
}
