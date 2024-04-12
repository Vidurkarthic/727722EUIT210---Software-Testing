// You are using Java
import java.util.*;
import java.sql.*;
class Department{
    public static void main(String args[])throws Exception
    {
     String url = "jdbc:mysql://localhost/ri_db";
     String username = "test";
     String password = "test123";
     
     Connection con = DriverManager.getConnection(url,username,password);
     Statement stmt=con.createStatement();
     try{
         ResultSet rs=stmt.executeQuery("select lower(Department_Name) from department");
         while(rs.next()){
             System.out.print(rs.getString(1)+"\n");
         }
     }
     catch(Exception e){
         System.out.println(e);
     }
    }
}