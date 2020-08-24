Assignment No: 04
Name : Sushama Jori
Roll No-58
Write a socket program in python/Java  to establish communication between multiple devices within the same network.

Server side program :
import java.net.*;
import java.io.*;
class client
{
	public static void main(String args[])throws Exception
	{ 
	Socket s =new Socket("127.0.0.1",1234);
	OutputStream os=s.getOutputStream();
	InputStream is =s.getInputStream();
	while(true)
	{
		byte b[]=new byte[50];
		is.read(b);
		String msg=new String(b);
		System.out.println(msg);
		DataInputStream dis=new DataInputStream(System.in);
		msg=dis.readLine();
		os.write(msg.getBytes());
	}
		
	}
}