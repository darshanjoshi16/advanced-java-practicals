//implementation client-server side sorting application
//this program denotes the server side of implementation of above stated application

//importing the I/O and networking Libraries
import java.io.*;
import java.net.*;

class Server
{
	public static void main(String ar[]) throws Exception
	{
        //creatio of serversocket at port number 2043
		ServerSocket serv_soc=new ServerSocket(2043);
		System.out.println("Server Started");
		
        //creation of socket object which will be accepting the request from client side
        Socket soc=serv_soc.accept();
		
        //PrintWriter object creation for output data on the output stream
        PrintWriter p_write=new PrintWriter(soc.getOutputStream());
		
        //BufferedReader object creation for reading the input data from buffer coming from client side
        BufferedReader in_read=new BufferedReader(new InputStreamReader(soc.getInputStream()));
		
        String num=in_read.readLine();
		
        int n=Integer.parseInt(num);
		
        System.out.println("Client want to sort "+n+" numbers");
		
        String sarr[]=new String[n];
		int arr[]=new int[n];
		int swap,c,d;
		
        System.out.println("received numbers::\n");
		for(int i=0;i<n;i++)
		{
			sarr[i]=in_read.readLine();
			arr[i]=Integer.parseInt(sarr[i]);
			System.out.println("index: "+i+"="+arr[i]);
		
		}

        //sorting the numbers recieved from  client side
	
		for (c = 0; c < ( n - 1 ); c++)
		{
			for (d = 0; d < n - c - 1; d++)
			{
				if (arr[d] > arr[d+1])
				{
					swap     = arr[d];
					arr[d]   = arr[d+1];
					arr[d+1] = swap;
				}
			}
		}
 
        //printing the resultant array of sorted output
		System.out.println("\nSorted list of numbers");
		
        String sendarr=new String();
		for (c = 0; c < n; c++) 
		{
			sendarr+="\nnum ("+c+")="+arr[c];
		}
		System.out.println(sendarr);
		
        p_write.println(sendarr);
		
        //deallocates the resources
        p_write.flush();
		
        //connection closing
        soc.close();
		
	}
}  