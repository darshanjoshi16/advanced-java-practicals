//implementation of storing procedure

//importing the libraries
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class p5 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
		Scanner sc= new Scanner(System.in);
        
        //establishing the DriverClass for our task execution 
         Class.forName("com.mysql.jdbc.Driver");
        
        //connection to practical 5 database in MySQL using JDBC Driver
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/practical5","root","");
        
        //preparing the callable statement using the connection
		CallableStatement cst = con.prepareCall("{call Get_Play_Name(?,?)}");
		cst.registerOutParameter(2,Types.VARCHAR);
		int n;
		System.out.println("enter 1 to continue and 0 to exit");
		n=sc.nextInt();
		while(n!=0) {
			System.out.println("enter id:");
			int id=sc.nextInt();
		
		cst.setInt(1,id);
		cst.execute();
		System.out.println(cst.getString(2));
		System.out.println("enter 1 to continue and 0 to exit");
		n=sc.nextInt();
		}
	}

}




