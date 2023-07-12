import java.sql.Connection;
import java.sql.ResultSet;

public class SMConn {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      Class.forName("com.sap.db.jdbc.Driver");

      String url = "jdbc:sap://localhost:39017?databaseName=hxe";
      url = "jdbc:sap://localhost:39017?closeHandlesOnFinalize=0";
//      String user = "system";
//      String password = "HanaXE!1";

      String user = "smdddev";
      String password = "SMRules123";

      Connection cn = java.sql.DriverManager.getConnection(url, user, password);

      // ... do whatever with the results ...
      System.out.println("asfdasdf");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}