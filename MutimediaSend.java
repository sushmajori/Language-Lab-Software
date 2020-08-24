
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

public class MutimediaSend extends JFrame implements ActionListener 
{
	Menu file;
	MenuBar mBar;
	MenuItem open;
	FileInputStream fis = null;
    BufferedInputStream bis = null;
    OutputStream os = null;
    ServerSocket servsock = null;
    Socket sock = null;
	final  int SOCKET_PORT = 13207;  // you may change this
	
	MutimediaSend()
	{
		mBar=new MenuBar();
		setMenuBar(mBar);
		setTitle("Server Mutimedia Panel");
		setSize(700,400);
		setVisible(true);
		file=new Menu("File");
		
		mBar.add(file);
		open=new MenuItem("Open");
		file.add(open);
	open.addActionListener(this);
    try {
	 	servsock = new ServerSocket(SOCKET_PORT);
		sock = servsock.accept();
        System.out.println("Accepted connection : " + sock);
        
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
	
		  
		JFileChooser fc =new JFileChooser();		
		int result =fc.showOpenDialog(null);
		if(result==JFileChooser.APPROVE_OPTION)
	     {
		  String FILE_TO_SEND = "a.wav";  // you may change this
		  FILE_TO_SEND=fc.getSelectedFile().getAbsolutePath();
			
			System.out.println(FILE_TO_SEND);
			
			
		    try {
		          System.out.println("Waiting...");
		          try {
		            // send file

		   File myFile = new File (FILE_TO_SEND);
		            byte [] mybytearray  = new byte [(int)myFile.length()];

		            fis = new FileInputStream(myFile);

		            bis = new BufferedInputStream(fis);

		            bis.read(mybytearray,0,mybytearray.length);

		            os = sock.getOutputStream();

		            System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");

		            os.write(mybytearray,0,mybytearray.length);

		            os.flush();
		          } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		          finally {
		            if (bis != null)
						try {
							bis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            if (os != null)
						try {
							os.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            if (sock!=null)
						try {
							sock.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		          
		        }
		      } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      finally {
		        if (servsock != null)
					try {
						servsock.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      }
		    }

		}
	
		

	
	public static void main(String args[])
	{
		new MutimediaSend().setVisible(true);
	}

}
  /*
  public static void main (String [] args ) throws IOException {
    try {
      servsock = new ServerSocket(SOCKET_PORT);
      while (true) {
        System.out.println("Waiting...");
        try {
          sock = servsock.accept();
          System.out.println("Accepted connection : " + sock);
          // send file

System.out.println("1");         
 File myFile = new File (FILE_TO_SEND);
System.out.println("2");
          byte [] mybytearray  = new byte [(int)myFile.length()];
System.out.println("3");

          fis = new FileInputStream(myFile);
System.out.println("4");

          bis = new BufferedInputStream(fis);
System.out.println("5");

          bis.read(mybytearray,0,mybytearray.length);
System.out.println("6");

          os = sock.getOutputStream();
System.out.println("7");

          System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
System.out.println("8");

          os.write(mybytearray,0,mybytearray.length);
System.out.println("9");

          os.flush();
          System.out.println("Done.");
        }
        finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (sock!=null) sock.close();
        }
      }
    }
    finally {
      if (servsock != null) servsock.close();
    }
  }

//@Override
}

*/
