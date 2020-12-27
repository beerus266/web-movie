package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Libraries.MovieLibrary;
import Model.Movie;
import Model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

//@WebServlet(name = "Servlet2")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ( this.checkSession(request, response) ) {
            try {
                // PrintWriter out = response.getWriter();

                HttpSession session = request.getSession();
                request.setAttribute("session", session);
                System.out.println("sess " + session.getAttribute("userId"));
                MovieLibrary movieLib = new MovieLibrary();
                List<Movie> movies = movieLib.getTop6NewMovie();

                request.setAttribute("newMovies", movies);

                movies = movieLib.getTop6RankMovie();
                request.setAttribute("rankMovies", movies);

                RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
                response.setContentType("text/html");
                request.setCharacterEncoding("UTF-8");

                dispatcher.forward(request, response);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    protected boolean checkSession(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("userId") == null ){
            response.sendRedirect("login");
            return false;
        }
        return true;
    }
}
