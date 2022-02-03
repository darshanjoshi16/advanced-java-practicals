//implementation of SQL CRUD Operations

//importing the libraries required for execution of task
import java.util.*;
import java.sql.*;

public class Practical4b {

	public static void main(String[] args) throws Exception,SQLException{
		
		//connection initialization and establishment with the database practical4 using JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/practical4", "root", "");
		
		//creating the SQL Statement object
		Statement stmt = cn.createStatement();
		ResultSet rs;
		int id_no;
		String name, sql , dept;

		//fetching the data from student table which is in database
		System.out.println("\n Student table contains Following Data :");
		rs = stmt.executeQuery("select * from students ORDER BY id_no");

		while (rs.next()) 
		{
			System.out.println(" " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
			
		//taking the input from user for CRUD operations
		Scanner in = new Scanner(System.in);					
		System.out.println("\n");
		System.out.print(" 1. SELECT DATA \n 2. INSERT DATA \n 3. UPDATE DATA \n 4. DELETE DATA \n 5. Exit ");					
		System.out.print(" \n\nEnter your Choice :");
		
		int n = in.nextInt();
		while (n < 6) 
		{
			switch (n)
			{
				//execution of SELECT Operation query
				case 1:
					System.out.println("\n Data of Database Student and Table Student_info :");
					rs = stmt.executeQuery("select * from students ORDER BY id_no");
					while (rs.next()) 
					{
						System.out.println(" " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
					}
					break;
				
				//execution of INSERT Operation query	
				case 2:
					System.out.println(" You have selected to insert Data Option.\n Please Enter Following details :");
					
					System.out.print(" Enter the id of Student:");
					id_no = in.nextInt();
					in.nextLine();
												
					System.out.print(" Enter Name of Student:");
					name = in.nextLine();
					System.out.print(" Enter Name of Department :");
					dept = in.nextLine();
					
					sql = "INSERT INTO `students` (`id_no`, `name`, `department`) VALUES ('" + Integer.toString(id_no) + "','" + name + "','" + dept + "')";
					stmt.executeUpdate(sql);
					
					rs = stmt.executeQuery("select * from students ORDER BY id_no");
					
					while (rs.next()) 
					{	
						System.out.println(" " + rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3));
					}
					break;
					
				//execution of UPDATE Operation query
				case 3:
					System.out.println(" You have selected to Update Data Option.\n Please Enter Following details :");
					System.out.print(" Enter the id of Student:");
												
					id_no = in.nextInt();						
					in.nextLine();
												
					System.out.print(" Enter Name of Student:");
					name = in.nextLine();
					
					System.out.print(" Enter dept of Student :");
					dept = in.nextLine();
					
					sql = "UPDATE students SET name=\"" + name + "\", department=\"" + dept + "\" WHERE id_no=" + id_no;
					stmt.executeUpdate(sql);
					
					rs = stmt.executeQuery("select * from students ORDER BY id_no");
					System.out.println(" Data updated Successfully...");
												
					while (rs.next()) 
					{
						System.out.println(" " + rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3));
					}
					break;
				
				// execution of DELETE Operation query	
				case 4:
					 System.out.println(" You have selected to Delete Data Option.\n Please Enter Following details :");
					 System.out.print(" Enter the id of Student:");
					 
					 id_no = in.nextInt();
					 in.nextLine();
					 sql = "DELETE FROM students WHERE  id_no=" + id_no;
					 stmt.executeUpdate(sql);
					 
					 rs = stmt.executeQuery("select * from students ORDER BY id_no");
					 System.out.println(" Data deleted Successfully...");
					 							
					 while (rs.next()) 
					 {
						 System.out.println(" " + rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3));
					 }
					 break;
				
				//Program Termination 
				case 5:
					System.out.println(" Exiting....");
					System.exit(0);
					break;
				
				//Correct value prompt for wrong value entered by user
				default:
					 System.out.println("Please Enter correct choice..");
				 break;
				}

				System.out.print("\n Enter your Choice :");
				n = in.nextInt();
			}
		//connection close with database using JDBC Driver
		cn.close();
	}
}
