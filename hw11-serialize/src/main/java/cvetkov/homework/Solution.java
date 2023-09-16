package cvetkov.homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) throws IOException {
        var mapper = new ObjectMapper();

        //считываем .json-файл в java-объект CommunObject
        String filePath = new File("hw11-serialize/src/main/resources/sms-256866-480df9.json").getAbsolutePath();
        var communObject = mapper.readValue(new File(filePath), CommunObject.class);
        System.out.println("communObject deserialized from file: " + filePath);
        System.out.println("communObject: " + communObject);
        System.out.println("_______________________");

        //создаем новую структуру
        NewStructure newStructure = null;
        for (ChatSession chatSession : communObject.getChatSessionList()) {
            String chatIdentifier = chatSession.getChatIdentifier();
            List<String> lastList = chatSession.getMembers().stream()
                    .map(member -> member.getLast())
                    .collect(Collectors.toList());

            Map<String, List<LightMessage>> messageMap = new HashMap<>();
            List<LightMessage> lightMessageList = chatSession.getMessages()
                    .stream().map(message -> {
                        LightMessage lightMessage = new LightMessage(
                                message.getBelongNumber(),
                                message.getSendDate(),
                                message.getText());
                        return lightMessage;
                    }).sorted(Comparator.comparing(LightMessage::getSendDate)).collect(Collectors.toList());

            lightMessageList.forEach(message -> messageMap
                    .computeIfAbsent(message.getBelongNumber(), key -> new ArrayList<>())
                    .add(message));

            newStructure = new NewStructure(chatIdentifier, lastList);
            newStructure.getMessages().putAll(messageMap);
        }
        System.out.println(newStructure);

        String filePathForNewJson = new File("hw11-serialize/src/main/resources/new.json").getAbsolutePath();
        File file = Path.of(filePathForNewJson).toFile();

        mapper.writerWithDefaultPrettyPrinter().writeValue(file, newStructure);
        System.out.println("newStructureList saved to: " + filePathForNewJson);

        var readedFileNewStructure = mapper.readValue(new File(filePathForNewJson), NewStructure.class);
        System.out.println("Deserialized: " + readedFileNewStructure);

    }
}
