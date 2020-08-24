import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.sun.speech.freetts.*;


public class Demo extends JFrame implements ActionListener
{
	JButton btn;
	JTextArea ta;
	private static final String VOICENAME="kevin16";
	Demo()
	{
	setSize(500,500);
	setLayout(null);
	
	btn=new JButton("Speak");
	ta=new JTextArea();
	ta.setBounds(20,20,150,200);
	btn.setBounds(190,20,80,40);
	add(btn);
	add(ta);
	btn.addActionListener(this);
	
	}
	
	
	public static void main(String args[])
	{
	new Demo().setVisible(true);
	
	}


	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		Voice voice;
		VoiceManager vm=VoiceManager.getInstance();
		voice=vm.getVoice(VOICENAME);
		voice.allocate();
		try
		{
			voice.speak(ta.getText());
			
		}
		catch(Exception e)
		{
			System.out.println("Error="+e);
		}
		
		
		
	}
	
}
