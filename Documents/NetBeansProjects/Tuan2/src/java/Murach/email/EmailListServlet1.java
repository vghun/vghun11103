/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Murach.email;

/**
 *
 * @author Admin
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import Murach.business.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class EmailListServlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response)
                         throws ServletException, IOException{
        String url = "/index.html";
        // get current action
        String action = request.getParameter("action");
        if (action == null){
            action = "join"; //default action
        }
        if(action.equals("join")){
            url="/index.html";// the "join" ;
        }
        else if (action.equals("add")){
            //get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email= request.getParameter("email");
      
            String social = request.getParameter("social");
            
            String contactMethod = request.getParameter("contact");
             // Retrieve the array of selected checkbox values
            String[] selectedOptions = request.getParameterValues("select[]");

        // Convert the array to a comma-separated string
            String optionsString = selectedOptions != null ? String.join(", ", selectedOptions) : "No options selected";
        

         String dateString = request.getParameter("birthday");
         LocalDate date = null;

        if (dateString != null && !dateString.isEmpty()) {
            try {
                date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                
            }
        }

        // Chuyển LocalDate sang chuỗi định dạng
        String formattedDate = date != null ? date.toString() : null;

           
          

           User user = new User(firstName, lastName, email,  formattedDate,social,optionsString,contactMethod);

            // set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";   // the "thanks" page
        }
        // forward request and response object to specificed URL 
        getServletContext()
               .getRequestDispatcher(url)
               .forward(request, response);
                              
    }
    @Override
     protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
                         throws ServletException, IOException{
                      doPost(request,response) ;
    }
}
