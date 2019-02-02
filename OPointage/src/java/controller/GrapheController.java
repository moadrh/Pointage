/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.mchange.v1.util.ListUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.PointageService;

/**
 *
 * @author dell
 */
@WebServlet(name = "GrapheController", urlPatterns = {"/GrapheController"})
public class GrapheController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String employe;
        Gson g = new Gson();
        PointageService ps = new PointageService();
        String op = request.getParameter("op");
        System.out.println("oper" + op);
        switch (op) {
            case "mois":
                employe = request.getParameter("employe");
                System.out.println("emp "+employe);
                List<String> mList = new ArrayList<String>();
                mList.add("Janvier");
                mList.add("Février");
                mList.add("Mars");
                mList.add("Avril");
                mList.add("Mai");
                mList.add("Juin");
                mList.add("Juillet");
                mList.add("Aout");
                mList.add("Septembre");
                mList.add("Octobre");
                mList.add("Novembre");
                mList.add("Décembre");
                List<Integer> mList2 = new ArrayList<Integer>();

                for (int i = 1; i < 13; i++) {
                    int n = ps.totalMinutebyMonth(Integer.parseInt(employe), i) / 60;
                    int nbrHeure = ps.totalHeurebyMonth(Integer.parseInt(employe), i) + n;
                    mList2.add(nbrHeure);
                }
                List<String> newList = new ArrayList<String>(mList);
                newList.add(mList2.toString());

                response.getWriter().write(g.toJson(newList));
                break;
            case "annee":
                employe = request.getParameter("employe");
                List<String> mList3 = new ArrayList<String>();
                mList3.add("2008");
                mList3.add("2009");
                mList3.add("2010");
                mList3.add("2011");
                mList3.add("2012");
                mList3.add("2013");
                mList3.add("2014");
                mList3.add("2015");
                mList3.add("2016");
                mList3.add("2017");
                mList3.add("2018");
                mList3.add("2019");

                List<Integer> mList4 = new ArrayList<Integer>();
                mList4.add(2008);
                mList4.add(2009);
                mList4.add(2010);
                mList4.add(2011);
                mList4.add(2012);
                mList4.add(2013);
                mList4.add(2014);
                mList4.add(2015);
                mList4.add(2016);
                mList4.add(2017);
                mList4.add(2018);
                mList4.add(2019);

                List<Integer> mList5 = new ArrayList<Integer>();
                for (int m : mList4) {
                    int n = ps.totalMinutebyYear(Integer.parseInt(employe), m) / 60;
                    int nbrHeure = ps.totalHeurebyYear(Integer.parseInt(employe), m) + n;
                    mList5.add(nbrHeure);
                }
                List<String> newList2 = new ArrayList<String>(mList3);
                newList2.add(mList5.toString());
                response.getWriter().write(g.toJson(newList2));
                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
