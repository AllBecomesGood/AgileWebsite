/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package uk.ac.dundee.computing.aec.instagrim.servlets;

import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
//import uk.ac.dundee.computing.aec.instagrim.models.User;

//Date and UUID classes
import java.util.Date;
import java.util.UUID;
//Quiz class
//import ;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "staffSubmitQuiz", urlPatterns = {"/staffSubmitQuiz"})
public class staffSubmitQuiz extends HttpServlet {
    Cluster cluster=null;
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        //cluster = CassandraHosts.getCluster();
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
        
        /*
        String title=request.getParameter("title");
        String moduleID=request.getParameter("moduleID");

        String available=request.getParameter("available"); //will be 1 or null

        //Use UUID, or let SQL auto-increment?
        UUID quizID = randomUUID();
        Date creationDate = new Date();

        int numOfQuestions = request.getParameter("questionsnumber");


        /////////////////Check if Quiz can be made/////////////////////////////////////
        boolean check=true;
        Quiz qz=new Quiz();
        check=qz.RegisterQuiz(title, moduleID);
        
        if (check==true)
        {

             //response.sendRedirect("/Quiz/SubmissionSuccess");
        }
        else
        {
              //response.sendRedirect("/Quiz/SubmissionError");
        }
         /////////////////////////////////////////////////////////////////////////////
         */

        numOfQuestions=request.getAttribute("questionsnumber");
        quizID=request.getAttribute("quizID");


        String questionTextName="questiontext";
        String explanationTextName="explanationtext";
        String validName="valid";
        String answerTextName="answertext";
        String correctName="correct";

        //Make arrays/vectors to insert question/answer info
        for (int i=0; i<numOfQuestions; i++)
        {
            //post the info of every question
            UUID questionID = randomUUID(); //get UUID in SQL?
            //RequestDispatcher rd = request.getRequestDispatcher("/staffSubmitQuiz.jsp")
            //request.setAttribute("questionID", questionID);

            String questionText = request.getParameter(questiontext+(i+1));
            String explanationText = request.getParameter(explanationtext+(i+1));
            String valid = request.getParameter(valid+(i+1); //will be 1 or null

            qz.SubmitQuestion(questionID, questionText, explanationText, valid, quizID);

            for (int j=0; j<4; j++)
            {
                //post the info of every answer
                UUID answerID = randomUUID(); //get UUID in SQL?
                //RequestDispatcher rd = request.getRequestDispatcher("/staffSubmitQuiz.jsp")
                //request.setAttribute("answerID", answerID);

                String answerText = request.getParameter(answertext+(i+1)+(j+1));
                String correct = request.getParameter(correct1+(i+1)+(j+1)); //will be 1 or null

                qz.SubmitAnswer(answerID, answerText, correct, questionID);
            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher rd=request.getRequestDispatcher("/staffSubmitQuiz.jsp");
        rd.forward(request,response);
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
