package cvetkov.homework.servlet;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;


public class OptionsATMServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String filePath = new File("hw15-web_server/src/main/resources/templates/takemoney.html").getAbsolutePath();
        byte [] smth = new FileInputStream(filePath).readAllBytes();
        String tmpl = new String(smth, Charset.forName("UTF-8"));
        response.setContentType("text/html");
        response.getWriter().println(tmpl);
    }
}
