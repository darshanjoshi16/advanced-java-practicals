//implementation client-server side sorting application
//this program denotes the client side of implementation of above stated application

//importing the I/O and networking Libraries
import java.io.*;
import java.net.*;

class Client
{
	public static void main(String ar[]) throws Exception
	{
        //creation of socket at port number 2043 and address of localhost
		Socket soc=new Socket("localhost",2043);
		
        //object creation of PrintWriter class which will help the output to be streamed
        PrintWriter p_write=new PrintWriter(soc.getOutputStream());
        
        //object creation of BufferReader class which will help to read the data from input stream
        BufferedReader in_read=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		BufferedReader ink=new BufferedReader(new InputStreamReader(System.in));
		
        System.out.println("How many numbers do you need to sort? ");
		int num=Integer.parseInt(ink.readLine());
		
        //write the data on output stream
        p_write.println(num);
		p_write.flush();
		
        System.out.println("Enter "+num+" numbers to sort :");
		
        //creating the array which will be storing the numbers entered by user on input stream
        String send_arr[]=new String[num];
		
        //taking the input on input stream by the user
        for(int i=0;i<num;i++)
		{
			System.out.print("index: "+i+"=");
			send_arr[i]=ink.readLine();
			p_write.println(send_arr[i]);
			p_write.flush();
		}
		
        String result;
		
        System.out.println("\nSorted array::\n");
		
        //storing the resultant array and printing them after performing the sorting at server side
        while((result=in_read.readLine())!=null)
		{
			System.out.println(result);
		}
        
        //closing the socket connection
		soc.close();
			
	}
}  