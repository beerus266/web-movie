package ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import ConnectionDB.ConnectionConfig;

public class CreateTable {

    //    public static void main(String[] args) throws JSONException {
//       JSONObject obj = new JSONObject();
//
//        obj.put("name", "foo");
//        obj.put("num", new Integer(100));
//        obj.put("balance", new Double(1000.21));
//        obj.put("is_vip", new Boolean(true));
//
//        System.out.print(obj);
//    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Connection conn = ConnectionConfig.initializeDatabase();
//        PreparedStatement st = conn.prepareStatement("insert into film values(?, ?, ?, ?)");
//        st.setInt(1, 4);
//        st.setString(2, "a");
//        st.setString(3, "b");
//        st.setString(4, "c");
//        st.executeUpdate();
        /*
         *  executeQuery() return a ResultSet, usually use in SELECT queries
         *  executeUpdate() return a int, usually use in INSERT, UPDATE, DELETE queries
         * */
        /* Statement usually use for Create Query */
        Statement stmt = conn.createStatement();
//        String sqlCreateTable = "CREATE TABLE Category"
//                                + "(id INTEGER not NULL, "
//                                +" Name VARCHAR(255), "
//                                +" Status VARCHAR(255), "
//                                +" PRIMARY KEY ( id ))";
//        String sqlChangeTable = "ALTER TABLE Category "
//                                +" MODIFY COLUMN Status INTEGER";
        String UserTableQuery =
                  "CREATE TABLE User "
                + "(id INTEGER not NULL,"
                + " Username VARCHAR(255) not NULL,"
                + " Password VARCHAR(255) not NULL,"
                + " Gmail VARCHAR(255) not NULL,"
                + " Phone VARCHAR(255),"
                + " Avatar VARCHAR(255),"
                + " role INTEGER DEFAULT 2,"
                + " status INTEGER DEFAULT 1,"
                + " PRIMARY KEY ( id ))";
        String CategoryTableQuery =
                 "CREATE TABLE Category"
                +"(id INTEGER not NULL, "
                +" Name VARCHAR(255) not NULL,"
                +" status INTEGER DEFAULT 1, "
                +" PRIMARY KEY ( id ))";
        String ActorTableQuery =
                 "CREATE TABLE Actor"
                +"(id INTEGER not NULL, "
                +" Name VARCHAR(255) not NULL,"
                +" Country VARCHAR(255) not NULL,"
                +" Birthday DATE not NULL,"
                +" status INTEGER DEFAULT 1, "
                +" PRIMARY KEY ( id ))";
        String MovieTableQuery =
                 "CREATE TABLE Movie"
                +"(id INTEGER not NULL, "
                +" Title VARCHAR(255) not NULL,"
                +" SubTitle NVARCHAR(255) not NULL,"
                +" Summary TEXT not NULL,"
                +" IMDBRank FLOAT, "
                +" Producer NVARCHAR(255), "
                +" Year YEAR, "
                +" Time INTEGER not NULL, "
                +" Quality VARCHAR(255), "
                +" UrlImg VARCHAR(255), "
                +" UrlMovie VARCHAR(255) not NULL, "
                +" status INTEGER DEFAULT 1, "
                +" PRIMARY KEY ( id ))";
        String CommentTableQuery =
                 "CREATE TABLE Comment"
                +"(id INTEGER not NULL, "
                +" MovieId INTEGER not NULL,"
                +" UserId INTEGER not NULL,"
                +" Content NVARCHAR(255), "
                +" LikeQuantity INTEGER DEFAULT 0, "
                +" ReplyCmtId INTEGER, "
                +" Time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                +" status INTEGER DEFAULT 1, "
                +" PRIMARY KEY ( id ))";
        String ActorMovieTableQuery =
                 "CREATE TABLE ActorMovie"
                +"( id INTEGER not NULL,"
                +" ActorId INTEGER not NULL,"
                +" MovieId INTEGER not NULL,"
                +" status INTEGER DEFAULT 1,"
                +" PRIMARY KEY ( id ))";
        String CateMovieTableQuery =
                 "CREATE TABLE CateMovie"
                +"( id INTEGER not NULL,"
                +" CateId INTEGER not NULL,"
                +" MovieId INTEGER not NULL,"
                +" status INTEGER DEFAULT 1,"
                +" PRIMARY KEY ( id ))";
        String WishListMovie =
                "CREATE TABLE wishlist"
                +" ( id INTEGER not NULL,"
                +" UserId INTEGER not NULL"
                +" MovieId INTEGER not NULL"
                +" status INTEGER DEFAULT 1,"
                +" PRIMARY KEY (id))";

        stmt.execute(UserTableQuery);
        stmt.execute(CategoryTableQuery);
        stmt.execute(ActorTableQuery);
        stmt.execute(MovieTableQuery);
        stmt.execute(CommentTableQuery);
        stmt.execute(ActorMovieTableQuery);
        stmt.execute(CateMovieTableQuery);
        stmt.execute(WishListMovie);

        stmt.close();
        conn.close();
        System.out.println("Done ! Create Database successfully !");
    }
}
