/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "TotalHeureController", urlPatterns = {"/TotalHeureController"})
public class TotalHeureController extends HttpServlet {

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
        PointageService ps = new PointageService();
        Gson g = new Gson();
        String employe;
        String date1;
        String date2;
        String op = request.getParameter("op");
        switch (op) {
            case "load":
                response.getWriter().write(g.toJson(ps.totalHeure()));
                break;
            case "employe":
                employe = request.getParameter("employe");
                response.getWriter().write(g.toJson(ps.totalHeurebyEmploye(Integer.parseInt(employe))));
                break;
            case "between":
                date1 = request.getParameter("date1").replace("-", "/");
                date2 = request.getParameter("date2").replace("-", "/");
                employe = request.getParameter("employe");
                System.out.println(" " + employe + " " + date1 + " " + date2);
                response.getWriter().write(g.toJson(ps.totalHeurebyEmployebetweenDates(Integer.parseInt(employe), new Date(date1), new Date(date2))));
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
