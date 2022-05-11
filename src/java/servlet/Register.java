/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Beans.Guest;
import DAO.DAOFactory;
import forms.RegisterFormChecker;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stag
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RegisterFormChecker checker = new RegisterFormChecker(request);
        Guest user = checker.check();
        if (checker.getErrors().isEmpty()) {
            // L'inscription est valide => utilisateur en session
            request.getSession().setAttribute("guest", user);
            // et utilisateur en DB !
            DAOFactory.getGuestDAO().create(user);
        } else {
            request.getSession().invalidate();
        }
        getServletContext()
                .getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Register controller";
    }

}
