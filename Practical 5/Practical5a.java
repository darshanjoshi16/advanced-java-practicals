//implementation of metadata of the table in the dataset 

//importing the libraries to executing the task 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Practical5a 
{
public static void main(String[] args) throws ClassNotFoundException, SQLException 
{
		int count=0;
		
		//establishing the DriverClass for our task execution 
		Class.forName("com.mysql.jdbc.Driver");
		
		//connection to practical 5 database in MySQL using JDBC Driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/practical5","root","");
		
		//statement creation with the connection with Resultset properties of 
		//TypeForward :In forward only ResultSet you can move the cursor only in forward direction 
		//ConcurUpdatable:It is a constant of the ResultSet class representing the concurrency mode for a ResultSet object that may be updated.
		Statement stmt=con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
	
		//execution of result set and executing the SQL Queries for getting the metadata
		ResultSet result = stmt.executeQuery("Select * from players");
		ResultSetMetaData rsmd=result.getMetaData();
		System.out.println("No of columns: "+rsmd.getColumnCount());
		System.out.println("Names of columns: "+rsmd.getColumnName(1) +" "+ rsmd.getColumnName(2) +" "+ rsmd.getColumnName(3));
		System.out.println("Types of the column: "+ rsmd.getColumnTypeName(1)+ " "+ rsmd.getColumnTypeName(2)+" "+ rsmd.getColumnTypeName(3));
	
		while(result.next() == true)
		{
			count++;
		}
		System.out.print("count of rows(records) in table: "+count);
		
	}
}


