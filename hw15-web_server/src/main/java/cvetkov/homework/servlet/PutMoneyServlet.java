package cvetkov.homework.servlet;

import cvetkov.homework.model.NominalBanknote;
import cvetkov.homework.services.AtmImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;


public class PutMoneyServlet extends HttpServlet {
    AtmImpl atm;
    public PutMoneyServlet(AtmImpl atm) {
        this.atm = atm;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        byte [] smth = new FileInputStream("/home/cvetkov/IdeaProjects/otus_java_2022_12_tsvetkov/hw15-web_server/src/main/resources/templates/putmoney.html").readAllBytes();
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
            atm.putBanknotes(NominalBanknote.HUNDRED, 5);
            System.out.println("fact balance hundred = " + atm.getBalance());
        }
        if (!req.getParameter("halfthousand").equals("")){
            halfthousandCount = Integer.parseInt(req.getParameter("halfthousand"));
            atm.putBanknotes(NominalBanknote.HALF_THOUSAND, halfthousandCount);
            System.out.println("fact balance = halfthousand" + atm.getBalance());
        }
        if (!req.getParameter("thousand").equals("")){
            thousandCount = Integer.parseInt(req.getParameter("thousand"));
            atm.putBanknotes(NominalBanknote.THOUSAND, thousandCount);
            System.out.println("fact balance = thousand" + atm.getBalance());
        }
        System.out.println("fact balance = " + atm.getBalance());
        resp.sendRedirect("/putmoney");
    }



}
