//importing the libraries which will be used in implementation of client side implementation of ConnectionLess Echo client server application
import java.net.*;
import java.io.*;

//declaring the public class
public class client
{   
    //UDPEchoReader class extends thread and it show the datagram socket establishment and activation.
    public static class UDPEchoReader extends Thread
    {   
        // it will activate the datagram socket
        public UDPEchoReader(DatagramSocket socket)
        {
            datagramSocket = socket;
            active = true;
        }
 
       public void run()
        {
            //it wll create a byte array object and create the Datagram Packet object with buffer and buffer.length as parameters
            byte[] buffer = new byte[1024];
            DatagramPacket incoming = new DatagramPacket(buffer,buffer.length);
            String receivedString;
 
            while(active)
            {
                try
                {
                    // listen for incoming datagram packet
                    datagramSocket.receive(incoming);
 
                   // print out received string
                     receivedString = new String(incoming.getData(),0, incoming.getLength());
                    System.out.println("Received from server:"+receivedString);
                }
                catch(IOException e)
                {
                    System.out.println(e);
                    active = false;
                }
            }
        }
 
        public boolean active; // it shows the current state of datagramsocket
        public DatagramSocket datagramSocket;
    }
 
    public static void main(String[] args)
    {
        // it will assign the port address because it uses UDP as its underlying protocol
        InetAddress address = null;
        int port = 5555;
        
        //initialized socket and buffered reader as null
        DatagramSocket datagramSocket = null;
        BufferedReader keyboardReader = null;
 
 
        // Create a Datagram Socket...
        try
        {
            address = InetAddress.getByName("127.0.0.1");
            datagramSocket = new DatagramSocket();
            keyboardReader = new BufferedReader(new InputStreamReader(System.in));
        }
 
        catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
 
        // Start the listening thread...
        
        UDPEchoReader reader = new UDPEchoReader(datagramSocket);
        reader.setDaemon(true);
        reader.start();
        System.out.println("Ready to send your messages...");
        
        try
        {
            String input;
            while (true)
            {
                // read input from the keyboard
                input = keyboardReader.readLine();
            
                // send datagram packet to the server
                DatagramPacket datagramPacket = new DatagramPacket(input.getBytes(), input.length(), address, port);
                datagramSocket.send(datagramPacket);
            }
        }
 
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
} 
