//Importing the libraries which will be used in practical of implementation of chat application..
import java.io.*;
import java.net.*;

//declaring the public class
public class server {
            public static void main(String[] args) throws Exception
            {
                        // creation of server socket object which is responsible for assigning the port number
                        ServerSocket ss=new ServerSocket(7888);
                        
                        //socket object accept the request from server socket object which is coming from client
                        Socket s= ss.accept();
                        
                        //DataInputStream object  is used to convert stream into UTF-8 Encoding manner
                        DataInputStream din=new DataInputStream(s.getInputStream());
                        String str;
                        str=din.readUTF();
                        System.out.println("Client:\t"+str);
                        
                        //DataOutputStream object is used to print the incoming message into terminal console.
                        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                        
                        //This object will take the stream from keyboard and consider it into input.
                        DataInputStream msg=new DataInputStream(System.in);
                        
                        //This section will continously print the messages recieved and sent messages into console.
                        while(true)
                        {
                                    str=din.readUTF();
                                    System.out.print("Client:\t"+str);
                                    System.out.print("Server:\t");
                                    str=msg.readLine();//it may show warning but you can use Xlint:deprecation to run the program
                                    dout.writeUTF(str);
                        }
            }
}
