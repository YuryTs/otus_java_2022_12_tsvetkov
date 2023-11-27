package ru.cvetkov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServerSocket {
    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    private static final String path = "HW20-websocket/src/main/resources/static";
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(9898)){
            System.out.println("Server started");

            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("new cline connected");
                new Thread(() -> handleRequest(socket)).start();

            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void handleRequest(Socket socket){
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())) {

            while (!input.ready()) ;
            String firstLine = input.readLine();
            String[] parts = firstLine.split(" ");
            while (input.ready()) {
                System.out.println(input.readLine());
            }

            Path pathToFile = Paths.get(path, parts[1]);
            if (!Files.exists(pathToFile)){
                output.println("HTTP/1.1 404 NOT FOUND");
                output.println("Content-Type: text/html; charest=utf-8");
                output.println();
                output.println("<h1>File not found</h1>");
                output.flush();
                return;
            }

            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charest=utf-8");
            output.println();
            Files.newBufferedReader(pathToFile).transferTo(output);
            output.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
