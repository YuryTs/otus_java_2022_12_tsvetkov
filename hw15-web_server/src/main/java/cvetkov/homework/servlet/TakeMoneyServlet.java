package cvetkov.homework.servlet;

import cvetkov.homework.services.AtmImpl;
import cvetkov.homework.services.BanknoteImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;


public class TakeMoneyServlet extends HttpServlet {
    AtmImpl atm;
    public TakeMoneyServlet(AtmImpl atm) {
        this.atm = atm;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        byte [] smth = new FileInputStream("/home/cvetkov/IdeaProjects/otus_java_2022_12_tsvetkov/hw15-web_server/src/main/resources/templates/takemoney.html").readAllBytes();
        String tmpl = new String(smth, Charset.forName("UTF-8"));
        response.setContentType("text/html");
        response.getWriter().println(tmpl);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cash = 0;
        if (!req.getParameter("cash").equals("")){
            cash = Integer.parseInt(req.getParameter("cash"));
            List<BanknoteImpl> list = atm.getBanknotes(cash);
        }
        resp.sendRedirect("/takemoney");
    }
}
