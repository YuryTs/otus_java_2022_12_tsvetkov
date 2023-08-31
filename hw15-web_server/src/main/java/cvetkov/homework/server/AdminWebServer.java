package cvetkov.homework.server;

public interface AdminWebServer {
    void start() throws Exception;
    void join() throws Exception;
    void stop() throws Exception;
    int getPort();
}
