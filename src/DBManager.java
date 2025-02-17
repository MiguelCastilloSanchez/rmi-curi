import java.sql.*;

/**
 * DBManager: Singleton pattern
 */
public final class DBManager { 

  private static DBManager _instance = null; 
  private Connection _con = null; 
  private static final String USER = "test";
  private static final String PASSWORD = "testingalgo";

  public DBManager() { 
    _con = getMySQLConnection(); 
  } 
  
  public static synchronized DBManager getInstance() { 
    if (_instance == null) { _instance = new DBManager(); }
    return _instance; 
  } 
  
  public Connection getConnection() { return _con; }
  
  private static Connection getMySQLConnection() { 
    Connection con = null; 
    try { 
      
        String strCon = "jdbc:mysql://localhost:3306/Province";

        con = DriverManager.getConnection(strCon, USER, PASSWORD); 
    } catch (SQLException se) { System.out.println(se); }
    return con; 
  } 
}
