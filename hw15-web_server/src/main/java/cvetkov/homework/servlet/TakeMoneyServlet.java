package cvetkov.homework.servlet;

import cvetkov.homework.services.impl.AtmImpl;
import cvetkov.homework.services.impl.BanknoteImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.File;
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
        String filePath = new File("hw15-web_server/src/main/resources/templates/takemoney.html").getAbsolutePath();
        byte [] smth = new FileInputStream(filePath).readAllBytes();
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
