//importing the library which is usefull to practical of server side implementation of Connection Oriented Echo client server application 

import java.io.*;  
import java.net.*;  

//declaring the public class
public class server
{  
    public static void main(String[] args)
    {  
        try
        {  
            // it creates the serverside socket at port number 5555
            ServerSocket ss=new ServerSocket(5555);  
            
            //establishes connection 
            Socket s=ss.accept();  
            
            //this object recieves the stream from client side at localhost and port number 5555 using established connection
            DataInputStream datainputs=new DataInputStream(s.getInputStream());  
           
            //converting the stream data into UTF-8 Encoding manner
            String  str=(String)datainputs.readUTF();  
            
            //printing the recieved message
            System.out.println("message recieved from client = "+str);  
           
            //it closes the serverside socket and demolishes the connection 
            ss.close();  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }  
    }  
}  
