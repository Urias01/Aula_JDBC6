package src.application;

import src.db.DB;
import src.db.DbIntegrityException;

import java.sql.*;

public class Program {

    public static void main(String[] args) {

       Connection conn = null;
       PreparedStatement st = null;

       try{
           conn = DB.getConnection();

           st = conn.prepareStatement(
                   "DELETE from department "
                   + "WHERE "
                   + "Id = ?"
           );

           st.setInt(1, 6);

          int rowsAffected = st.executeUpdate();
          System.out.println("Done! Rows affected: " + rowsAffected);
       }
       catch(SQLException e){
           throw new DbIntegrityException(e.getMessage());
       }
       finally {
           DB.closeStatement(st);
           DB.closeConnection();
       }
    }
}
