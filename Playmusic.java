
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class Playmusic
{
		//JFileChooser fc =new JFileChooser();		
		//int result =fc.showOpenDialog(null);
		//if(result==JFileChooser.APPROVE_OPTION)
	Playmusic(String inputFile)
		{
			try
			{
				File file=new File(inputFile);
				FileInputStream fis=new FileInputStream(file);
				BufferedInputStream bis=new BufferedInputStream(fis);
				try
				{
					Player player=new Player(bis);
				//	System.out.println(fc.getSelectedFile().getAbsolutePath());
					player.play();
				}
				catch(JavaLayerException e)
				{
					System.out.println("Can't Open File");
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
