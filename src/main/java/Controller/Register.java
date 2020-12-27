package Controller;

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
import ConnectionDB.ConnectionConfig;



    @WebServlet(name = "register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random rd = new Random();
        int id = rd.nextInt(2147483647);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gmail= request.getParameter("gmail");
        String phone =request.getParameter("phone");
        HashingPassword hashingPassword=new HashingPassword();
        password=hashingPassword.Hashingpassword(password);

        try {

//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/movieweb", "root", "root");
            Connection con = ConnectionConfig.initializeDatabase();
            Statement st = con.createStatement();

          String queryusername="SELECT Username from User WHERE Username= '"+username+"'";
            ResultSet rs =  st.executeQuery(queryusername);
    String checkname = "";
            while ( rs.next() ) {
                 checkname = rs.getString("Username");
            }

             if(checkname.equals(username)){
                 System.out.println("sai1111");

             }else{
                 String insert = "INSERT INTO user (id,Username, Password, Gmail, Phone, Avatar, role,status) VALUES ('"+id+"','"+username+"','"+ password+"','" +gmail+"','" +phone+"','"+ null+"','"+1+"','"+1+"' )";



                 System.out.println(insert);

                 st.executeUpdate(insert);
                 con.close();
                 response.sendRedirect("login");
             }

        }
        catch (Exception e){
            System.out.print(e);
            e.printStackTrace();
        }


    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        System.out.println(session.getAttribute("userid"));
    response.sendRedirect("register.jsp");
    }
}
