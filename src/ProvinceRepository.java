import java.sql.*;
import java.util.*;

public class ProvinceRepository { 

  public static int save(Province p) { 
    int iRet = -1; 
    try { 
      Connection con = DBManager.getInstance().getConnection(); 
      String SQL = "INSERT INTO Province (Id, ShortName, Name) values(?,?,?)"; 
      PreparedStatement pstmt = con.prepareStatement(SQL); 
      pstmt.setInt(1, p.getId()); 
      pstmt.setString(2, p.getShortName()); 
      pstmt.setString(3, p.getName()); 
      iRet = pstmt.executeUpdate(); 
      pstmt.close(); 
    } catch (SQLException se) { System.out.println(se); }
    return iRet; 
  } 
}
