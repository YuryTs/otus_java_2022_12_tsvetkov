package cvetkov.homework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cvetkov.homework.dao.InMemoryUserDao;
import cvetkov.homework.dao.UserDao;
import cvetkov.homework.model.NominalBanknote;
import cvetkov.homework.server.AdminWebServer;
import cvetkov.homework.server.AdminWebServerImpl;
import cvetkov.homework.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebServer {
    static final Logger log = LoggerFactory.getLogger(WebServer.class);

    private static final String TEMPLATES_DIR = "/templates/";

    public static void main(String[] args) throws Exception {
        AtmImpl atm = new AtmImpl();
        UserDao userDao = new InMemoryUserDao();
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        TemplateProcessor templateProcessor = new TemplateProcessorImpl(TEMPLATES_DIR);
        UserAuthService authService = new UserAuthServiceImpl(userDao);
        AdminWebServer server = new AdminWebServerImpl(gson, templateProcessor, authService, atm, userDao);

        server.start();
        log.info("WebServer started!");
        server.join();

    }


}
