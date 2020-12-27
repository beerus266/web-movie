package Controller;

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

import Libraries.MovieLibrary;
import Model.Comment;
import Model.Movie;
import org.json.JSONObject;

@WebServlet(name = "DetailMovieController")
public class DetailMovieController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (this.checkSession(request,response))
        {
            int id = Integer.parseInt(String.valueOf(request.getParameter("id")));
            //        System.out.println(id);

            try {
                MovieLibrary movLib = new MovieLibrary();
                Movie mov = movLib.getMovieById(id);

                HttpSession session = request.getSession();

                List<Comment> comments = movLib.getComment(id);
                request.setAttribute("comments", comments);
                request.setAttribute("session", session);
                request.setAttribute("movie", mov);
                //            System.out.println(mov.getId());

                RequestDispatcher rd = request.getRequestDispatcher("DetailMovie.jsp");
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
