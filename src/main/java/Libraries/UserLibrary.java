package Libraries;

import ConnectionDB.ConnectionConfig;
import Model.Movie;
import Model.User;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserLibrary {
    Connection conn = ConnectionConfig.initializeDatabase();
    PreparedStatement pstm;
    ResultSet rs;

    public UserLibrary() throws SQLException, ClassNotFoundException {
    }

    public String getUsernameById(int userId) throws SQLException {
        pstm = conn.prepareStatement("SELECT * FROM user WHERE status = 1 AND id = " + userId);
//        ResultSetMetaData rsmd ;

        rs = pstm.executeQuery();

        String username = "";
        while ( rs.next() ) {
            username = rs.getString(1);
        }
        return  username;
    }
}
