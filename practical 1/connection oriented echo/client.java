//importing the library which is usefull to practical of client side implementation of Connection Oriented Echo client server application 
import java.io.*;
import java.net.*; 

//declaring the public class
public class client {

    public static void main(String Args[])
    {
        try
        {
            //creating the socket object  at localhost and port number 5555
            Socket s = new Socket("localhost",5555);
            
            //it takes the keyboard input and stream the data into socket which will be appearing on terminal and server side
            DataOutputStream dataout=new DataOutputStream(s.getOutputStream());  
            
            //it will convert the stream into UTF-8 Encoding manner
            dataout.writeUTF("Hello Server, Its Your Client Darshan");  
           
            //flush() method forces bytes to be written to the underlying stream.
            dataout.flush();  
            
            //it closes the stream
            dataout.close();  
           
            //it will closing the socket at given ip address and port number
            s.close();  

            

        }
        
        catch (Exception e) {
            System.out.println(e);
        }
    }


    
}
