package cvetkov.homework.server;

import com.google.gson.Gson;
import cvetkov.homework.dao.UserDao;
import cvetkov.homework.helpers.FileSystemHelper;
import cvetkov.homework.services.impl.AtmImpl;
import cvetkov.homework.services.TemplateProcessor;
import cvetkov.homework.services.UserAuthService;
import cvetkov.homework.servlet.*;
import cvetkov.homework.utils.JettyPropertyReader;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.FilterHolder;

import java.util.Arrays;

public class AdminWebServerImpl implements AdminWebServer {
    private static final String START_PAGE_NAME = "index.html";
    private static final String COMMON_RESOURCES_DIR = "static";

    private int port;



    private final Server server;
    private final Gson gson;
    protected final TemplateProcessor templateProcessor;
    private final UserAuthService authService;
    AtmImpl atm;
    private final UserDao userDao;

    public AdminWebServerImpl(Gson gson, TemplateProcessor templateProcessor, UserAuthService authService, AtmImpl atm, UserDao userDao) {
        JettyPropertyReader reader = new JettyPropertyReader();
        port = reader.getPort();
        this.gson = gson;
        this.templateProcessor = templateProcessor;
        this.server = new Server(port);
        this.authService = authService;
        this.atm = atm;
        this.userDao = userDao;
    }

    @Override
    public void start() throws Exception {
        if (server.getHandlers().length == 0) {
            initContext();
        }
        server.start();
    }

    @Override
    public void join() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public int getPort() {
        return port;
    }

    private Server initContext(){
        ResourceHandler resourceHandler = createResourceHandler();

        ServletContextHandler servletContextHandler = createServletContextHandler();

        HandlerList handlerList = new HandlerList();
        handlerList.addHandler(resourceHandler);
        handlerList.addHandler(applySecurity(servletContextHandler, "/users"));



        server.setHandler(handlerList);
        return server;
    }

    protected Handler applySecurity(ServletContextHandler servletContextHandler, String... paths) {
        servletContextHandler.addServlet(new ServletHolder(new LoginServlet(templateProcessor, authService)), "/login");
        AuthorizationFilter authorizationFilter = new AuthorizationFilter();
        Arrays.stream(paths).forEachOrdered(path -> servletContextHandler.addFilter(new FilterHolder(authorizationFilter), path, null));
        return servletContextHandler;
    }

    private ResourceHandler createResourceHandler() {
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(false);
        resourceHandler.setWelcomeFiles(new String[]{START_PAGE_NAME});
        resourceHandler.setResourceBase(FileSystemHelper.localFileNameOrResourceNameToFullPath(COMMON_RESOURCES_DIR));
        return resourceHandler;
    }

    private ServletContextHandler createServletContextHandler() {
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        servletContextHandler.addServlet(new ServletHolder(new BalanceServlet(atm)), "/balance");
        servletContextHandler.addServlet(new ServletHolder(new PutMoneyServlet(atm)), "/putmoney");
        servletContextHandler.addServlet(new ServletHolder(new TakeMoneyServlet(atm)), "/takemoney");
        servletContextHandler.addServlet(new ServletHolder(new OptionsATMServlet()), "/options");

        servletContextHandler.addServlet(new ServletHolder(new UsersServlet(templateProcessor, userDao)), "/users");

        return servletContextHandler;
    }
}
