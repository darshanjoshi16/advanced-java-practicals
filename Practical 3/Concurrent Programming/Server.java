//implementation of concurrent programming using TCP connection
//this program shows the server side implementation of above stated application

//importing the  I/O and Networking libraries
import java.net.*;
import java.io.*;


public class Server 
{
    public static void main(String[] args)throws Exception
    {
        int count=1;
        System.out.println("Server is running...................");

        //creation of server side socket at port number 4320  
        ServerSocket serv_soc=new ServerSocket(4320);

        //this loop allows multiple clients object creation and connection
        while(true)
        {
            new RevThread(serv_soc.accept(),count).start();
            System.out.println(count+" client connected");
            count++;
        }
    }
}

//reverseThread classes uses Threading and Thread Class properties which is usefull for connecting multiple clients
class RevThread extends Thread
{
    Socket s=null;
    int n;
    
    //method initialize the socket and client count
    public RevThread(Socket socket,int count)
    {
        s=socket;
        n=count;
    }
 
    public void run()
    {
        
        try
        {
            //this loop recieves the data from multiple clients and perform the reversing the string returns the string to particular client
            while(true)
            {
                System.out.println("receiving from client "+n);
                DataInputStream din=new DataInputStream(s.getInputStream());
                
                String str=din.readUTF();
                System.out.println("processing data of Client "+n);
                
                StringBuffer rev=new StringBuffer();
                rev=rev.append(str);
                rev=rev.reverse();
                
                String revStr=new String(rev);
                System.out.println("sending to client "+n);
                
                DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                dout.writeUTF(revStr);
            }
        }
  
        catch(IOException e)
        {
   
            System.out.println(e);
  
        }
    }
}