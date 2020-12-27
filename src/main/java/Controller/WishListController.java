package Controller;

import Libraries.MovieLibrary;
import Libraries.WishListLibrary;
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
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "WishListController")
public class WishListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this.checkSession(request, response))
        {
            try {
                //            System.out.println("asfasd");
                WishListLibrary wlLib = new WishListLibrary();
                HttpSession session = request.getSession();
                List<Movie> movies = new ArrayList<Movie>();

                int userId = Integer.parseInt(String.valueOf(session.getAttribute("userId")));
                //            int userId = 268471489;
                System.out.println(userId);

                movies = wlLib.getWishListById(userId);
                System.out.println(movies.get(0).getTitle());
                request.setAttribute("movies", movies);

                RequestDispatcher rd = request.getRequestDispatcher("WishList.jsp");
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
