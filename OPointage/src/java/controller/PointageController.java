/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Employe;
import beans.Pointage;
import beans.Pointagecomplet;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.PongMessage;
import services.EmployeService;
import services.PointagecompletService;
import services.PointageService;

/**
 *
 * @author dell
 */
@WebServlet(name = "PointageController", urlPatterns = {"/PointageController"})
public class PointageController extends HttpServlet {

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
        EmployeService es = new EmployeService();
        PointageService ps = new PointageService();
        PointagecompletService pcs = new PointagecompletService();
        String id;
        String date;
        String etat;
        String employe;
        String date1;
        String date2;
        String employe1;
        String op = request.getParameter("op");
        Gson g = new Gson();
        String dat;

        switch (op) {
            case "load":
                response.getWriter().write(g.toJson(ps.findAll()));
                break;
            case "add":
                date = request.getParameter("date").replace("T", " ");
                System.out.println("hhjij" + date);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date d = format.parse(date);
                System.out.println("  dd --->" + d);
                etat = request.getParameter("etat");
                employe = request.getParameter("employe");

                ps.create(new Pointage(d, etat, es.findById(Integer.parseInt(employe))));

                if (etat.equals("sortie")) {
                    int e = ps.lastPointage(Integer.parseInt(employe));
                    int a = ps.beforeLastPointage(Integer.parseInt(employe));
                    Pointage p2 = ps.findById(e);
                    Pointage p1 = ps.findById(a);
                    if (p1.getEtat().equals("entree")) {

                        Date d1 = p1.getDate();
                        Date d2 = p2.getDate();

                        //Insertion d'un enregistrement dans la table pointageComplet
                        Date de = format.parse(d1.toString());
                        Date ds = format.parse(d2.toString());

                        Employe e1 = es.findById(Integer.parseInt(employe));
                        String nom1 = e1.getNom();
                        String prenom1 = e1.getPrenom();

                        pcs.create(new Pointagecomplet(de, ds, es.findById(Integer.parseInt(employe))));

                        System.out.println(" -->" + d1);
                        System.out.println(" -->" + d2);
                        String s1 = d1.toString().substring(11, 13);
                        String s2 = d2.toString().substring(11, 13);

                        int r1 = Integer.parseInt(s1);
                        int r2 = Integer.parseInt(s2);

                        System.out.println(" ghh " + s1 + " , " + s2);
                        System.out.println(" ghh " + r1 + " , " + r2);

                        if (r2 == 0) {
                            r2 = 24;
                        }
                        if (r1 > 11 && r2 < 12 && r2 != 0) {
                            r2 = r2 + 24;
                        }

                        int j = r2 - r1; // heure de sotie moins heure d'entrée

                        String m1 = d1.toString().substring(14, 16);
                        String m2 = d2.toString().substring(14, 16);

                        int f1 = Integer.parseInt(m1);
                        int f2 = Integer.parseInt(m2);

                        int y = f2 - f1; //minute de sotie moins minute d'entrée

                        int nbrMin;
                        int nbrHeure;
//                         p2.setNbrHeure(j);
//                         p2.setNbrMinute(y);
//                         ps

                        if (y < 0) {

                            nbrMin = y + 60;
                            nbrHeure = j - 1;
                            p2.setNbrMinute(nbrMin);
                            p2.setNbrHeure(nbrHeure);
                            ps.update(p2);

                        } else {
                            nbrMin = y;
                            nbrHeure = j;
                            p2.setNbrMinute(nbrMin);
                            p2.setNbrHeure(nbrHeure);
                            ps.update(p2);
                        }
                        System.out.println("kk " + m1 + " kk " + m2 + " ll " + y);

                        int v = e1.getNbrMinute() + y;
                        int l = e1.getNbrHeure() + j;
                        System.out.println(" l " + l);
                        System.out.println(" -- " + e1.getNbrMinute());

                        if (v < 0) { // verification des minutes
                            int ad = l - 1;
                            int ar = v + 60;
                            e1.setNbrHeure(ad);
                            e1.setNbrMinute(ar);
                            es.update(e1);
                        } else if (v >= 60) {
                            int ad = l + 1;
                            int ar = v - 60;
                            e1.setNbrHeure(ad);
                            e1.setNbrMinute(ar);
                            es.update(e1);
                        } else {
                            e1.setNbrHeure(l);
                            e1.setNbrMinute(v);
                            es.update(e1);
                        }
                    }
                }

                response.getWriter().write(g.toJson(ps.findAll()));
                break;
            case "delete":
                id = request.getParameter("id");
                //employe1 = request.getParameter("employe1");
                ps.delete(ps.findById(Integer.parseInt(id)));

//                String dat1 = request.getParameter("date1").replace("T", " ");
//                format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//                String dat2 = request.getParameter("date2").replace("T", " ");
//                if (employe1 == null) {
                response.getWriter().write(g.toJson(ps.findAll()));
//                } else if (employe1 != null) {
//                    response.getWriter().write(g.toJson(ps.findPointagebyEmploye(Integer.parseInt(employe1))));
//                }
//                } else if (employe1 != null && dat1 != null) {
//                    Date da1 = format.parse(dat1);
//                    Date da2 = format.parse(dat2);
//                    response.getWriter().write(g.toJson(ps.findPointagesBetweenDates(Integer.parseInt(employe1), da1, da2)));
//                }
                break;

            case "update":
                id = request.getParameter("id");
                date = request.getParameter("date").replace("T", " ");
                format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                d = format.parse(date);
                etat = request.getParameter("etat");
                employe = request.getParameter("employe");
                Pointage p = ps.findById(Integer.parseInt(id));
                p.setDate(d);
                p.setEtat(etat);
                p.setEmploye(es.findById(Integer.parseInt(employe)));
                ps.update(p);
                response.getWriter().write(g.toJson(ps.findAll()));
                break;
            case "between":
                date1 = request.getParameter("date1").replace("T", " ");
                format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date d1 = format.parse(date1);
                date2 = request.getParameter("date2").replace("T", " ");
                Date d2 = format.parse(date2);
                employe1 = request.getParameter("employe1");
                System.out.println(" " + employe1 + " " + date1 + " " + date2);
                response.getWriter().write(g.toJson(ps.findPointagesBetweenDates(Integer.parseInt(employe1), d1, d2)));
                break;
            case "employe":
                employe1 = request.getParameter("employe1");
                System.out.println("hid " + employe1);
                if (employe1 == "hidden") {
                    response.getWriter().write(g.toJson(ps.findAll()));
                } else {
                    response.getWriter().write(g.toJson(ps.findPointagebyEmploye(Integer.parseInt(employe1))));
                }
                break;
            case "list":
                employe = request.getParameter("employe");
                System.out.println(" eee " + employe);
                int e = ps.lastPointage(Integer.parseInt(employe));
                response.getWriter().write(g.toJson(ps.findById(e)));
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
            Logger.getLogger(PointageController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PointageController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
