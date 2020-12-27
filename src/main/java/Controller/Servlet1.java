package Controller;

import org.json.JSONException;
import org.json.JSONObject;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Login")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JSONObject a = new JSONObject();

        BufferedReader br =
                new BufferedReader(new InputStreamReader(request.getInputStream()));
        /* Another way to get JSON from JSP */
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = br.readLine()) != null) {
//            sb.append(line);
//        }
//        try {
//            JSONObject json = new JSONObject(sb.toString());
//            System.out.println(json);
//            System.out.println(json.get("email"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        /* Another way 2 to get JSON from JSP */
        String str = "";
        if(br != null){
            str = br.readLine();
            //System.out.println(str);
            try {
                JSONObject json = new JSONObject(str);
                System.out.println(json.get("email1"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        PrintWriter out = response.getWriter();

        // Set response content type
//        response.setContentType("text/html");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        pass = request.getParameter("json");
        System.out.println(user +" aa"+pass);

        try {
            a.put("user", user);
            a.put("pass", pass);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        out.print(a);
        out.flush();
    }
}
