<%--
    Document   : staffEditQuiz
    Created on : Feb 21, 2017, 10:13:40 AM
    Author     : Musa
--%>

<%@page import="Beans.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.QuizDetails"%>
<%-- <%@page import="Beans.EditQuiz"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Quiz</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>

        <div class="page-header col-sm-offset-2">
            <h1>Edit Quiz</h1>
            <form method = "POST" action = "StaffEditQuiz">
        </div>

        <%
            QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails");
            //EditQuiz quizDetails = (EditQuiz) session.getAttribute("EditQuiz"); 
        %>

        <form class="form-horizontal" method="Post" action="StaffEditQuiz">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label"></label>
                <div class="col-sm-10 col-md-4">
                    <input type="text" class="form-control" name="title" id="inputEmail3" value=" <%= quizDetails.getTitle()%>">
                </div>
            </div>
            
                <div class="form-group" style="width: 100%;">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <% if (quizDetails.getAvailability()) {%>
                                <input name="availability" type="checkbox" checked>
                                <%} else {%> 
                                <input name="availability" type="checkbox"><%}%> Availability
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group" style="width: 100%;">
                    <div class="col-sm-offset-2 col-sm-10">
                        <h4>Date: <%= quizDetails.getDate()%></h4>
                    </div>
                </div>
                <div class="form-group" style="width: 100%;">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input  class="btn btn-lg btn-primary" id='button' onclick="showDiv()" value="See Questions"/>
                    </div>
                </div>




                
                    <div id="showDiv" style="display: none; background-color: red;">

                        <% for (int x = 0; x < quizDetails.getQuestions().size(); x++) { %>

                        <% ArrayList<Answer> answers = quizDetails.getQuestions().get(x).getAnswers();%>

                        <div class="col-sm-offset-2 col-sm-8">
                            <div class="panel panel-default" style="margin-left: -15px;">
                                <!-- Default panel contents -->

                                <div class="panel-heading"><h4><%=x + 1%>.  
                                        <input type="hidden"  name="id<%=x%>" value="<%= quizDetails.getQuestions().get(x).getQuestionID()%>">
                                        <input name="QuestionText<%=x%>" value="<%= quizDetails.getQuestions().get(x).getQuestionText()%>"> </h4></div>
                                <div class="panel-body">
                                    <p><b><h5>Explanation: </b> <input name="ExplanationText<%=x%>" value="<%=quizDetails.getQuestions().get(x).getExplanation()%>"> </h5></p>
                                </div>
                                <input type="hidden" name="ExplanationText<%=x%>" value="<%=quizDetails.getQuestions().get(x).getExplanation()%>">
                                <% for (int y = 0; y < answers.size(); y++) {%>
                                <!-- List group -->
                                <ul class="list-group">
                                    <li class="list-group-item" > 
                                        <input type="hidden" name="answerid<%=x%><%=y%>" value="<%= answers.get(y).getID()%>"/>
                                        <input name="answertext<%=x%><%=y%>" value="<%= answers.get(y).getText()%>"/> 
                                        <input type="checkbox" name="correct<%=x%><%=y%>" <% if (answers.get(y).getCorrect() == 1) {%> checked<% }%>></li>
                                </ul>
                                <% }%>  
                            </div>  

                        </div>
                        <% }%>
                        <input type="hidden" name="QuestionNumber" value="<%= quizDetails.getQuestions().size()%>">

                        <div class="form-group" style="width: 100%;">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input  type = "submit" class="btn btn-lg btn-primary" id='button' value = "Submit"></input>

                            </div>
                        </div>
                    </div>
                </form>
                <script>

                    function showDiv() {
                        document.getElementById('showDiv').style.display = "block";
                        document.getElementById('button').style.display = "none";
                    }
                </script>
                </body>
                </html>
