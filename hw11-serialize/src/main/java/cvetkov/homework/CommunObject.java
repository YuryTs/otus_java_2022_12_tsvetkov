package cvetkov.homework;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class CommunObject implements Serializable {
    @JsonProperty("chat_sessions")
    List<ChatSession> chatSessionList;


    public List<ChatSession> getChatSessionList() {
        return chatSessionList;
    }

    public void setChatSessionList(List<ChatSession> chatSessionList) {
        this.chatSessionList = chatSessionList;
    }

    @Override
    public String toString() {
        return "CommunObject{" +
                "chatSessionList=" + chatSessionList +
                '}';
    }
}
