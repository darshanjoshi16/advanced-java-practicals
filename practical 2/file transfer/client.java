//importing the library used in the practical of implementation of file transfer using TCP Protocol

import java.io.*;
import java.net.*;

//declaration of public client
public class client {

            public static void main(String[] args) throws Exception
            {
                                    //creation of socket object on client side using ip address and port number
                                    Socket s=new Socket("127.0.0.1",7777);
                                   
                                   //connection acknowledgement with serverside application using isConnected method
                                    if(s.isConnected())
                                    {
                                                System.out.println("Connected to server");
                                    }
                                    
                                    //it will create the "recieved.txt" file and will output means write the content into file
                                    FileOutputStream fout= new FileOutputStream("received.txt");
                                    
                                    //it will take input from the socket which is  receiving input file from server
                                    DataInputStream din=new DataInputStream(s.getInputStream());
                                    
                                    //Below logic will seperate every character in the input and read and write it untill it will encounter the null character or EOF.
                                    int r;
                                    while((r=din.read())!=-1)
                                    {
                                                fout.write((char)r);
                                    }
                                    s.close();
            }

}
