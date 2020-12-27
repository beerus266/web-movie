package Controller;

import Libraries.MovieLibrary;
import Model.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchMovieController")
public class SearchMovieController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (this.checkSession(request, response))
        {
            String name = request.getParameter("searchField");

            try {
                MovieLibrary movLib = new MovieLibrary();
                List<Movie> movies = movLib.searchMovieByName(name);
                request.setAttribute("movies", movies);
                System.out.println(movies.size());
                RequestDispatcher rd = request.getRequestDispatcher("SearchMovie.jsp");
                rd.forward(request, response);

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
