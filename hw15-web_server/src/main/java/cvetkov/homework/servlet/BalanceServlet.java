package cvetkov.homework.servlet;

import cvetkov.homework.services.AtmImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


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
        byte [] smth = new FileInputStream("/home/cvetkov/IdeaProjects/otus_java_2022_12_tsvetkov/hw15-web_server/src/main/resources/templates/balance.html").readAllBytes();
        String tmpl = new String(smth, Charset.forName("UTF-8"));
        String result = tmpl.replace("$balance", String.valueOf(atm.getBalance()));
        response.setContentType("text/html");
        response.getWriter().println(result);
    }

}
