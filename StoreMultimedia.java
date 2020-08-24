package myproject;
import java.sql.*;
import java.io.*;

public class StoreMultimedia 
{
	
	StoreMultimedia()
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","12345");
		System.out.println("Connection is Successful");
		PreparedStatement ps=con.prepareStatement("insert into multimedia values(?,?) ");
ps.setString(1, "file1");
String filePath="G:/Freshers.mp3";
File audioFile=new File(filePath);
FileInputStream fis=new FileInputStream(audioFile);

ps.setBinaryStream(2, (InputStream) fis, (int) (audioFile.length()));
ps.executeUpdate();
	System.out.println("Data Stored Succcessfully");
		con.close();

		}
		catch(Exception e)
		{ System.out.println(e);
		}

		
	}
	
public static void main(String args[])
{
	new StoreMultimedia();
	
}
}
