package Libraries;

import ConnectionDB.ConnectionConfig;
import Model.Movie;
import Model.WishList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishListLibrary {


    Connection conn = ConnectionConfig.initializeDatabase();
    PreparedStatement pstm ;
    ResultSet rs;

    public WishListLibrary() throws SQLException, ClassNotFoundException {
    }

    public List<Movie> getWishListById ( int userId) throws SQLException {
            pstm = conn.prepareStatement("SELECT * FROM movie, wishlist" +
                                            " WHERE wishlist.status = 1 AND wishlist.userId = "+userId+
                                            " AND movie.id = wishlist.movieId");
//        System.out.println(pstm.toString());
        List<Movie> movies = new ArrayList<Movie>();

//        System.out.println(pstm.toString());
        rs = pstm.executeQuery();

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

    public void addToList (int userId, int movieId) throws SQLException {
        PreparedStatement st = conn.prepareStatement("insert into wishlist(userId, movieId) values( ?, ?)");
        st.setInt(1, userId);
        st.setInt(2, movieId);
        System.out.println(st.toString());
        st.executeUpdate();
        st.close();
    }

    public void removeFromList(int userId, int movieId) throws SQLException {
        PreparedStatement st = conn.prepareStatement("update wishlist set status = 0 where userId = ? and movieId = ? ");
        st.setInt(1, userId);
        st.setInt(2, movieId);
        System.out.println(st.toString());
        st.executeUpdate();
        st.close();
    }


}
