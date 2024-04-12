// You are using Java
// You are using Java
import java.util.*;
import java.sql.*;
class Main{
    public static void main(String args[])throws Exception{
        Scanner sc=new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
        int n=Integer.parseInt(sc.nextLine());
        if(n==1){
           int id=Integer.parseInt(sc.nextLine());
           String name=sc.nextLine();
           int cont=Integer.parseInt(sc.nextLine());
           String pl=sc.nextLine();
           String ph=sc.nextLine();
           PreparedStatement ps=con.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?)");
           ps.setInt(1,id);
           ps.setString(2,name);
           ps.setInt(3,cont);
           ps.setString(4,pl);
           ps.setString(5,ph);
           int rows=ps.executeUpdate();
           if(rows>=1){
               System.out.println("Customer record inserted successfully.");
           }
        }
        else if(n==2){
           int id=Integer.parseInt(sc.nextLine());
           String name=sc.nextLine();
           int cont=Integer.parseInt(sc.nextLine());
           String pl=sc.nextLine();
           String ph=sc.nextLine();
           PreparedStatement ps=con.prepareStatement("UPDATE customer SET name=?, contact_information=?,subscription_plan=?, payment_history=? where customer_id=?");
           ps.setInt(5,id);
           ps.setString(1,name);
           ps.setInt(2,cont);
           ps.setString(3,pl);
           ps.setString(4,ph);
           int up=ps.executeUpdate();
           if(up>=1){
               System.out.println("Customer record updated successfully.");
           }
  
        }
        if(n==3 || n==2 || n==1){
            Statement st=con.createStatement();
            String sts="SELECT * FROM customer";
            ResultSet rs=st.executeQuery(sts);
            while(rs.next()){
                System.out.print("ID: "+rs.getString("customer_id")+", ");
                System.out.print("Name: "+rs.getString("name")+", ");
                System.out.print("Contact Information: "+rs.getString("contact_information")+", ");
                System.out.print("Subscription Plan: "+rs.getString("subscription_plan")+", ");
                System.out.print("Payment History: "+rs.getString("payment_history")+"\n");
            }
        }
        else{
            System.out.println("Invalid operation number. Please try again.");
        }
    }
}