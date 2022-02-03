// implementation of practical 4-A (JDBC Intro)

//importing the SQL class library for execution of JDBC Programming
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Practical4a {

	public static void main(String[] args) throws Exception,SQLException 
	{
		Scanner s1 = new Scanner(System.in);
		
		//initialization of MySQL driver which is imported from external JAR
		Class.forName("com.mysql.jdbc.Driver");
		
		//establishment of connection with JDBC Driver and Database situated with MySQL
		//Name of the database is Practical4 and table name is students
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/practical4", "root", "");
		
		//creation and execution of SQL Statement
		Statement str = con.createStatement();
		ResultSet res = str.executeQuery("select * from  students  ORDER BY id_no  DESC");
		
		System.out.println("---------------------------------------------------------");
		System.out.println("Student Table");
        System.out.println("---------------------------------------------------------");
		System.out.println("Displaying records in reverse order by their Id_No");
		System.out.println("----------------------------------------------------------");
		System.out.println("Id_No       Student_Name        Department");
		System.out.println("----------------------------------------------------------");

		//fetching the data from the database
		while(res.next())
		{
			String Name = res.getString("name");
			int id = res.getInt("id_no");
			String dept = res.getString("department");
			System.out.println(id+ "           " + Name +"           " + dept);
			System.out.println("------------------------------------------------------");
		}
		
		System.out.println("\n");
		
		int temp = 2;
		
		//inserting the new record in the database as per asked
		while(temp != 0)
		{
			//taking input from user
			System.out.print("Enter Id_No: ");
			int id = s1.nextInt();
			System.out.print("Enter Student_Name: ");
			String name = s1.nextLine();
			if(name == "")
				name = s1.nextLine();
			System.out.print("Enter Branch: ");
			String dept1 = s1.nextLine();
			if(dept1 == "")
				dept1 = s1.nextLine();
			
			//executing the INSERT Operation
			String query = "INSERT INTO `students`(`id_no`, `name`, `department`) VALUES ('" + Integer.toString(id) + "','" + name + "','" + dept1 + "')";
			str.executeUpdate(query);
			System.out.println("Record had been inserted in student_table.");
			System.out.println("-----------------------------------------------------------");
			temp -= 1;
		}
		
		//displaying the updated Table in the database
		ResultSet res1 = str.executeQuery("select * from  students  ORDER BY id_no  DESC");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" Display Student Table");
		
		while(res1.next())
		{
			int id = res1.getInt("id_no");
			String Name = res1.getString("name");
			String dept = res1.getString("department");
			System.out.println( id+ "           " + Name +"         " + dept);
			System.out.println("-----------------------------------------------------------  -");
		}
		
		System.out.println("\n");	

	}

}
