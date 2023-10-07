package etu002087.demandebesoin;
import java.sql.*;

public class ConnectPostgres {
    
    public  ConnectPostgres (){}
    public Connection getconnection(){
      try {

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rh_employee","postgres","root");
            return conn;

      } catch (Exception e) {
        System.out.println(e);
      }
      return null;
    }
}
