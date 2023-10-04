package cvetkov.homework;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewStructure implements Serializable {

    @JsonProperty("chat_identifier")
    private String chatIdentifier;
    @JsonProperty("last")
    private List<String> lastList;

    @JsonProperty("message")
    private Map<String, List<LightMessage>> messages = new HashMap<>();

    public NewStructure(String chatIdentifier, List<String> lastList) {
        this.chatIdentifier = chatIdentifier;
        this.lastList = lastList;
    }

    public NewStructure() {
    }

    public String getChatIdentifier() {
        return chatIdentifier;
    }

    public void setChatIdentifier(String chatIdentifier) {
        this.chatIdentifier = chatIdentifier;
    }

    public List<String> getLastList() {
        return lastList;
    }

    public void setLastList(List<String> lastList) {
        this.lastList = lastList;
    }

    public Map<String, List<LightMessage>> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, List<LightMessage>> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "NewStructure{" +
                "chatIdentifier='" + chatIdentifier + '\'' +
                ", lastList=" + lastList +
                ", messages=" + messages +
                '}';
    }
}
