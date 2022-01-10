//Importing the libraries which will be used in practical of implementation of chat application..
import java.io.*;
import java.net.Socket;

//declaring the public class
public class client
{
            public static void main(String[] args) throws Exception 
            {           
                        //creation of socket object with ip address and port number
                        Socket s=new Socket("127.0.0.1",7888);
                        
                        //connection aknowledgement from server
                        if(s.isConnected())
                        {
                                    System.out.println("Connected to server");
                        }
                        
                        
                        // creation of Data Input Stream object which takes input from user using system.in class method
                        DataInputStream msg=new DataInputStream(System.in);
                        
                        String str="Start Chat..............................................................................................";
                        
                        //creation of Data Output Stream object which  allows an application to write primitive Java data types to the output stream in a machine-independent way.
                        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                        
                        //It is used to write a string to the output stream using UTF-8 encoding in portable manner.
                        dout.writeUTF(str);
                        System.out.println(str);
                        
                        //this object will recieve the data stream from server 
                        DataInputStream din=new DataInputStream(s.getInputStream());
                        
                        //this section will recieve the stream then read it in UTF-8 encoding and print out the message to console.
                        while(true)
                        {
                                    System.out.print("Client:\t");
                                    str=msg.readLine(); // it may show warning but you can use Xlint:deprecation to run the program
                                    dout.writeUTF(str+"\n");
                                    str=din.readUTF();
                                    System.out.println("Server:\t"+str);
                        }
            }
}
