package cvetkov.homework.servlet;

import cvetkov.homework.model.NominalBanknote;
import cvetkov.homework.services.impl.AtmImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;


public class PutMoneyServlet extends HttpServlet {
    AtmImpl atm;
    public PutMoneyServlet(AtmImpl atm) {
        this.atm = atm;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String filePath = new File("hw15-web_server/src/main/resources/templates/putmoney.html").getAbsolutePath();
        byte [] smth = new FileInputStream(filePath).readAllBytes();
        String tmpl = new String(smth, Charset.forName("UTF-8"));
        response.setContentType("text/html");
        response.getWriter().println(tmpl);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int hundredCount = 0;
        int halfthousandCount = 0;
        int thousandCount = 0;
        if (!req.getParameter("hundred").equals("")){
            hundredCount = Integer.parseInt(req.getParameter("hundred"));
            atm.putBanknotes(NominalBanknote.HUNDRED, hundredCount);
        }
        if (!req.getParameter("halfthousand").equals("")){
            halfthousandCount = Integer.parseInt(req.getParameter("halfthousand"));
            atm.putBanknotes(NominalBanknote.HALF_THOUSAND, halfthousandCount);
        }
        if (!req.getParameter("thousand").equals("")){
            thousandCount = Integer.parseInt(req.getParameter("thousand"));
            atm.putBanknotes(NominalBanknote.THOUSAND, thousandCount);
        }
        resp.sendRedirect("/putmoney");
    }



}
