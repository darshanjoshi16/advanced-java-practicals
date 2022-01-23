import java.io.*;
import java.net.*;

public class Client2 
{
 public static void main(String[] args) throws Exception
 {
  Socket soc=new Socket("127.0.0.1",4320);
  if(soc.isConnected())
  {
   System.out.println("Connected to Server....");
  }
  while(true)
  {
   System.out.println("Enter String to reverse:");
   DataInputStream in=new DataInputStream(System.in);
   String str=in.readLine();
   DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
   dout.writeUTF(str);
   
   DataInputStream din=new DataInputStream(soc.getInputStream());
   String rev=din.readUTF();
   System.out.println("Reversed String:\t"+rev);
  }
 } 
}