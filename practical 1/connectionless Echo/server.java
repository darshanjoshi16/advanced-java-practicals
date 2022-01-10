//importing the libraries which will be used in implementation of server side implementation of ConnectionLess Echo client server application

import java.io.*;
import java.net.*;

//declaring the public class
public class server
{
    public static void main(String args[])
    {
        //assigning the port number for socket
        int port = 5555;
        
        //initialization of socket with null
        DatagramSocket serverDatagramSocket = null;
       
        try
        {
            // it will create a server at given port number and acknowledge the server creation
            serverDatagramSocket = new DatagramSocket(port);
            System.out.println("The Connectionless Echo server is created at port "+port);

        }
        catch(IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }

        try 
        {
            //it will create a byte array object and create the DatagramPacket object with buffer and buffer.length as parameters
            byte buffer[] = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            String input;

            while(true)
            {
            
                // listen for datagram packets
                serverDatagramSocket.receive(datagramPacket);
                
                input = new String(datagramPacket.getData(), 0,
                datagramPacket.getLength());
                
                System.out.println("Received from server: "+input);
                
                // send received packet back to the client
                serverDatagramSocket.send(datagramPacket);
            }


        } 
        
        catch (Exception e) 
        {
            System.out.println(e);

        }
    }
}
