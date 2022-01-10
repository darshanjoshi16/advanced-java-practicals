//importing the libraries which will be useful in practical of implementation of file transfer using TCP protocol.
import java.io.*;
import java.net.*;

//declaring the public class
class server
{
            public static void main(String args[]) throws Exception
            {
                        //creation of serverside socket at the port number 7777
                        ServerSocket ss=new ServerSocket(7777);
                        
                        //this object will accept the connection request from client and acknowledge the connection
                        Socket s=ss.accept();
                        System.out.println("connected..........");
                        
                        //this will create file stream and file named "send.txt" and it will make the file ready to output via DataOutputStream
                        FileInputStream fin=new FileInputStream("Send.txt");
                        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                        
                        //below logic will separate the characters in "send.txt" and creating the copy which is to be transfered untill it encounters the null character or EOF.
                        int r;
                        while((r=fin.read())!=-1)
                        {
                                    dout.write(r);
                                   
                        }
                        
                        System.out.println("\nFile Transfer Completed using TCP");
                        
                        //closing of the sockets
                        s.close();
                        ss.close();
            }
}
