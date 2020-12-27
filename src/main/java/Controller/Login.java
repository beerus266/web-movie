package Controller;

import ConnectionDB.ConnectionConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;



@WebServlet(name = "login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 try {
     String username1 = request.getParameter("username");
     String password = request.getParameter("password");
     HttpSession session = request.getSession();

     String username=  username1.replaceAll("[-+.^:,']","");

     HashingPassword hashingPassword=new HashingPassword();
     password=hashingPassword.Hashingpassword(password);
     String Query = "Select * from User WHERE  Username='"+username+"'AND Password='"+password+"' ";
     //System.out.println(Query);
     //2nd step
     Class.forName("com.mysql.jdbc.Driver");
     //3rd step
//     Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test1", "root", "root");
     //4th step
     Connection con = ConnectionConfig.initializeDatabase();
     Statement st = con.createStatement();
     //5th step
     ResultSet rs = st.executeQuery(Query);
     rs.next();
     String name="";
      name = rs.getString("Username");
     if(name!=""){
//         System.out.println(name + "trong ham");
         session = request.getSession();
         String userid =rs.getString("id");
         session.setAttribute("userId", userid);
         session.setAttribute("name", name);
         response.setContentType("text/html");
//         PrintWriter out = response.getWriter();
//         out.print("<div>Login OK</div>");

         response.sendRedirect("index");
     }



//     System.out.println(name);

     //6th step
     con.close();
 }
 catch (Exception e){
     response.setContentType("text/html");
     PrintWriter out = response.getWriter();
     out.print("<div>That Bai</div>");
     System.out.println(e);

 }




    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        System.out.println(session.getAttribute("userid"));
        System.out.println(session.getAttribute("name"));
        response.sendRedirect("login.jsp");
    }
}
