/*
	Assignment No: 04

Name : Sushama Jori
Roll No-58
Write a socket program in python/Java  to establish communication between multiple devices within the same network.

Server side program:*/
import java.net.*;
import java.io.*;
class server 
{
public static void main(String args[])throws Exception
	{
		ServerSocket ss=new ServerSocket(1234);
		Socket s=ss.accept();
		InputStream is=s.getInputStream();
		OutputStream os=s.getOutputStream();
		while(true)
		{
			DataInputStream dis=new DataInputStream(System.in);
			String msg=dis.readLine();
			os.write(msg.getBytes());
			byte b[]=new byte[50];
			is.read(b);
			msg=new String(b);
			System.out.println(msg);
 
		}
	}
}