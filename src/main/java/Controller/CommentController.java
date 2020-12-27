package Controller;

import Libraries.MovieLibrary;
import Libraries.WishListLibrary;
import Model.Comment;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "comment")
public class CommentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this.checkSession(request, response))
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            HttpSession session = request.getSession();
            PrintWriter out = response.getWriter();
//        System.out.println(session.getAttribute("userId"));
            int userId = Integer.parseInt(String.valueOf(session.getAttribute("userId")));
//        System.out.println(userId);

            try {
                MovieLibrary wlLib = new MovieLibrary();
                String data = "";
                if (br != null) {
                    data = br.readLine();
                    //System.out.println(str);
                    try {
                        System.out.println("hihihih");
                        JSONObject dataJson = new JSONObject(data);
                        String content = dataJson.getString("content");
//                    wlLib.addToList(userId,movieId);
                        wlLib.AddComment(userId, content, dataJson.getInt("movieid"));
                        out.print("Success");
                    } catch (JSONException e) {

                        e.printStackTrace();
                    }

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
