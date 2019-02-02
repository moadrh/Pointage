/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Employe;
import beans.Fonction;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.EmployeService;
import services.FonctionService;
import services.RoleService;

/**
 *
 * @author dell
 */
@WebServlet(name = "EmployeController", urlPatterns = {"/EmployeController"})
public class EmployeController extends HttpServlet {

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
        EmployeService es = new EmployeService();
        FonctionService fs = new FonctionService();
        RoleService rs = new RoleService();
        String id;
        String nom;
        String prenom;
        String sexe;
        String dateN;
        String tel;
        String adresse;
        String email;
        String password;

        String dateE;
        String role;
        String fonction;
        Gson g = new Gson();
        String op = request.getParameter("op");
        switch (op) {
            case "load":
                response.getWriter().write(g.toJson(es.findAll()));
                break;
            case "add":
                nom = request.getParameter("nom");
                prenom = request.getParameter("prenom");
                sexe = request.getParameter("sexe");
                dateN = request.getParameter("dateN").replace("-", "/");
                tel = request.getParameter("tel");
                adresse = request.getParameter("adresse");
                email = request.getParameter("email");
                password = request.getParameter("password");
                dateE = request.getParameter("dateE").replace("-", "/");
                role = request.getParameter("role");
                fonction = request.getParameter("fonction");
                System.out.println(" " + nom + " " + prenom + " " + sexe + " " + dateN + " " + tel + " " + adresse + " " + email + " " + password + " " + role + " " + fonction);
                es.create(new Employe(nom, prenom, sexe, new Date(dateN), tel, adresse, new Date(dateE), email, password, fs.findById(Integer.parseInt(fonction)), rs.findById(Integer.parseInt(role))));
                response.getWriter().write(g.toJson(es.findAll()));
                break;
            case "delete":
                id = request.getParameter("id");
                es.delete(es.findById(Integer.parseInt(id)));
                response.getWriter().write(g.toJson(es.findAll()));
                break;
            case "update":
                id = request.getParameter("id");
                nom = request.getParameter("nom");
                prenom = request.getParameter("prenom");
                sexe = request.getParameter("sexe");
                dateN = request.getParameter("dateN").replace("-", "/");
                tel = request.getParameter("tel");
                adresse = request.getParameter("adresse");
                email = request.getParameter("email");
                password = request.getParameter("password");
                dateE = request.getParameter("dateE").replace("-", "/");
                role = request.getParameter("role");
                fonction = request.getParameter("fonction");
                Employe e = es.findById(Integer.parseInt(id));
                e.setAdresse(adresse);
                e.setDateEmbauche(new Date(dateE));
                e.setDateNaissance(new Date(dateN));
                e.setEmail(email);
                e.setFonction(fs.findById(Integer.parseInt(fonction)));
                e.setNom(nom);
                e.setPassword(password);
                e.setPrenom(prenom);
                e.setRole(rs.findById(Integer.parseInt(role)));
                e.setSexe(sexe);
                e.setTelephone(tel);
                es.update(e);

                response.getWriter().write(g.toJson(es.findAll()));
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
