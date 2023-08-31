package cvetkov.homework.servlet;

import cvetkov.homework.services.impl.AtmImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;


public class BalanceServlet extends HttpServlet {

    private AtmImpl atm;

    public BalanceServlet(AtmImpl atm) {
       this.atm = atm;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String filePath = new File("hw15-web_server/src/main/resources/templates/balance.html").getAbsolutePath();
        byte [] smth = new FileInputStream(filePath).readAllBytes();
        String tmpl = new String(smth, Charset.forName("UTF-8"));
        String result = tmpl.replace("$balance", String.valueOf(atm.getBalance()));
        response.setContentType("text/html");
        response.getWriter().println(result);
    }

}
