/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dagi
 */
@WebServlet(name = "ClearTheFilter", urlPatterns = {"/ClearTheFilter",})
public class ClearTheFilter extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        session.setAttribute("Filtered", false);

       response.sendRedirect("GetResults");
        /* RequestDispatcher rd = request.getRequestDispatcher("/GetResults");
        rd.forward(request, response);*/
        
        /*
        if (request.getRequestURI().equals("GetResults")) {
            RequestDispatcher rd = request.getRequestDispatcher("/GetResults");
            rd.forward(request, response);
        } else if (request.getServletPath().equals("RelevantResults")) {
            RequestDispatcher rd = request.getRequestDispatcher("/RelevantResults");
            rd.forward(request, response);
        }*/
    }
    


}
