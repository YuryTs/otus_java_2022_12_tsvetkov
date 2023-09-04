package cvetkov.homework.servlet;

import cvetkov.homework.dao.UserDao;
import cvetkov.homework.services.TemplateProcessor;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class UsersServlet extends HttpServlet {

//    private static final String USERS_PAGE_TEMPLATE = "users.html";
//    private static final String TEMPLATE_ATTR_RANDOM_USER = "randomUser";

    private final UserDao userDao;
    private final TemplateProcessor templateProcessor;

    public UsersServlet(TemplateProcessor templateProcessor, UserDao userDao) {
        this.templateProcessor = templateProcessor;
        this.userDao = userDao;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String filePath = new File("hw15-web_server/src/main/resources/templates/options.html").getAbsolutePath();
        byte [] smth = new FileInputStream(filePath).readAllBytes();
        String tmpl = new String(smth, Charset.forName("UTF-8"));
        response.setContentType("text/html");
        response.getWriter().println(tmpl);
    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
//        Map<String, Object> paramsMap = new HashMap<>();
//        userDao.findByNumberCard(Arrays.toString(req.getParameter("numberCard"))).ifPresent(existUser -> paramsMap.put(TEMPLATE_ATTR_RANDOM_USER, existUser));
//
//        response.setContentType("text/html");
//        response.getWriter().println(templateProcessor.getPage(USERS_PAGE_TEMPLATE, paramsMap));
//    }

}
