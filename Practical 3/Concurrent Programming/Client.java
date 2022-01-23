//implementation of concurrent programming using TCP connection
//this program shows the client side implementation of above stated application

//I have created the same program on the name of client 2 so that I can show the implementation of concurrency as per convinience

//importing the I/O and Networking libraries
import java.io.*;
import java.net.*;

public class Client 
{
 public static void main(String[] args) throws Exception
 {
  //creation of socket at port number 4320 and address of localhost
  Socket soc=new Socket("127.0.0.1",4320);
  
  //it checks the acknowledgement of connection whether the socket is connected at given port number or not.
  if(soc.isConnected())
  {
   System.out.println("Connected to Server....");
  }
  
  //this loop allows the user to enter the string they want to reverse and get the output on stream
  while(true)
  {
   System.out.println("Enter String to reverse:");
   DataInputStream in=new DataInputStream(System.in);
   String str=in.readLine();
   DataOutputStream data_out=new DataOutputStream(soc.getOutputStream());
   data_out.writeUTF(str);
   
   DataInputStream data_in=new DataInputStream(soc.getInputStream());
   String rev=data_in.readUTF();
   System.out.println("Reversed String:\t"+rev);
  }
 } 
}