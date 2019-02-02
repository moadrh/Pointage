/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Pointage;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.EmployeService;
import services.PointageService;

/**
 *
 * @author dell
 */
@WebServlet(name = "RecherchePointage", urlPatterns = {"/RecherchePointage"})
public class RecherchePointage extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("application/json;charset=UTF-8");
        PointageService ps = new PointageService();
        String id;
        String date1;
        String date2;
        String employe;
        String op = request.getParameter("op");
        Gson g = new Gson();
        switch (op) {
            case "between":
                date1 = request.getParameter("date1").replace("T", " ");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date d1 = format.parse(date1);
                date2 = request.getParameter("date2").replace("T", " ");
                Date d2 = format.parse(date2);
                employe = request.getParameter("employe");
                System.out.println(" " + employe + " " + date1 + " " + date2);
                response.getWriter().write(g.toJson(ps.findPointagesBetweenDates(Integer.parseInt(employe), d1, d2)));
                break;
            case "employe":
                employe = request.getParameter("employe");
                response.getWriter().write(g.toJson(ps.findPointagebyEmploye(Integer.parseInt(employe))));
                break;
            case "delete":
                id = request.getParameter("id");
                employe = request.getParameter("employe");
                ps.delete(ps.findById(Integer.parseInt(id)));
                response.getWriter().write(g.toJson(ps.findPointagebyEmploye(Integer.parseInt(employe))));
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RecherchePointage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RecherchePointage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
