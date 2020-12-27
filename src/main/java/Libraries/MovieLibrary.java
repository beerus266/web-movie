package Libraries;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.Comment;
import Model.Movie;

import ConnectionDB.ConnectionConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieLibrary {

    Connection conn = ConnectionConfig.initializeDatabase();
    PreparedStatement pstm ;
    ResultSet rs;

    public MovieLibrary() throws SQLException, ClassNotFoundException {
    }

    public void AddComment(int userid, String content, int movieid){
        Random rd = new Random();
        int id = rd.nextInt(2147483647);
//        System.out.println("add "+userid+" "+content+" "+movieid);
        try {
            pstm = conn.prepareStatement("insert into comment(id, MovieId, UserId, Content, Time) values( ?, ?, ?, ?, ?)");
            pstm.setInt(1, id);
            pstm.setInt(2, movieid);
            pstm.setInt(3, userid);
            pstm.setString(4, content);
            pstm.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Movie> getTop6NewMovie() throws SQLException {
        pstm = conn.prepareStatement("SELECT * FROM Movie WHERE status = 1 ORDER BY Year desc LIMIT 8");
        List<Movie> movies = new ArrayList<Movie>();
//        ResultSetMetaData rsmd ;

        rs = pstm.executeQuery();
//        rsmd = rs.getMetaData();
//        System.out.println(rsmd.getColumnName(2));
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("Title");
            String titleSub = rs.getString("SubTitle");
            String summary = rs.getString("summary");
            float IMDBRank = rs.getFloat("IMDBRank");
            String Producer = rs.getString("Producer");
            int Year = rs.getInt("Year");
            String Time = rs.getString("Time");
            String Quan  = rs.getString("Quality");
            String UrlImg = rs.getString("UrlImg");
            String UrlMovie = rs.getString("UrlMovie");

            Movie mov = new Movie(id, title, titleSub, summary, IMDBRank, Producer, Year, Time, Quan, UrlImg, UrlMovie);

            movies.add(mov);
        }

        return movies;
    }

    public List<Movie> getTop6RankMovie() throws SQLException {
        pstm = conn.prepareStatement("SELECT * FROM Movie WHERE status = 1 ORDER BY IMDBRank desc LIMIT 8");
        List<Movie> movies = new ArrayList<Movie>();
//        ResultSetMetaData rsmd ;

        rs = pstm.executeQuery();
//        rsmd = rs.getMetaData();
//        System.out.println(rsmd.getColumnName(2));
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("Title");
            String titleSub = rs.getString("SubTitle");
            String summary = rs.getString("summary");
            float IMDBRank = rs.getFloat("IMDBRank");
            String Producer = rs.getString("Producer");
            int Year = rs.getInt("Year");
            String Time = rs.getString("Time");
            String Quan  = rs.getString("Quality");
            String UrlImg = rs.getString("UrlImg");
            String UrlMovie = rs.getString("UrlMovie");

            Movie mov = new Movie(id, title, titleSub, summary, IMDBRank, Producer, Year, Time, Quan, UrlImg, UrlMovie);

            movies.add(mov);
        }

        return movies;
    }

    public Movie getMovieById(int id) throws SQLException {
        pstm = conn.prepareStatement("SELECT * FROM Movie WHERE id = " + id);
        rs = pstm.executeQuery();

        Movie mov = null;
        if (rs.next()) {
            mov = new Movie(rs.getInt("id"), rs.getString("Title"),
                    rs.getString("SubTitle"), rs.getString("Summary"),rs.getFloat("IMDBRank"),
                    rs.getString("Producer"), rs.getInt("Year"),
                    rs.getString("Time"), rs.getString("Quality"),
                    rs.getString("UrlImg"), rs.getString("UrlMovie"));
        }

        return mov;
    }

    public List<Movie> searchMovieByName (String name) throws SQLException {
        pstm = conn.prepareStatement("SELECT * FROM Movie WHERE Title LIKE '%"+name+"%' OR SubTitle LIKE '%"+name+"%'");

//        System.out.println(pstm.toString());
        rs = pstm.executeQuery();
        List<Movie> movies = new ArrayList<Movie>();
        Movie mov = null;

        while (rs.next()) {
            mov = new Movie(rs.getInt("id"), rs.getString("Title"),
                    rs.getString("SubTitle"), rs.getString("Summary"), rs.getFloat("IMDBRank"),
                    rs.getString("Producer"), rs.getInt("Year"),
                    rs.getString("Time"), rs.getString("Quality"),
                    rs.getString("UrlImg"), rs.getString("UrlMovie"));
            movies.add(mov);
        }

        return movies;
    }

    public int commentMovie(JSONObject json) throws SQLException {

        int result = 0;
        try {
            int userId = json.getInt("userId");
            int movieId = json.getInt("movieId");
            String content = json.getString("content");

//            pstm = conn.prepareStatement("SELECT * FROM Movie WHERE Title LIKE '%"+name+"%' OR TitleSub LIKE '%"+name+"%'");
            PreparedStatement st = conn.prepareStatement("insert into comment values(?, ?, ?, ?, ?, ?, ?, ?)");

            st.setInt(1, userId);
            st.setInt(2, movieId);
            st.setString(3, content);

            result = st.executeUpdate();



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  result;
    }

    public List<Comment> getComment(int movieid){
//        System.out.println(pstm.toString());
        List<Comment> comments = new ArrayList<Comment>();

//        System.out.println(pstm.toString());
        try {
            pstm = conn.prepareStatement("SELECT * FROM comment,user WHERE MovieId = ? AND user.id = comment.UserId ORDER BY Time asc ");
            pstm.setInt(1, movieid);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Comment mov = new Comment();

                mov.setId(rs.getInt("id"));
                mov.setMovieId(rs.getInt("MovieId"));
                mov.setUserId(rs.getInt("UserId"));
                mov.setUsername(rs.getString("Username"));
                mov.setContent(rs.getString("Content"));
                mov.setTime(rs.getTimestamp("Time").toString());

                comments.add(mov);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return comments;
    }
}
