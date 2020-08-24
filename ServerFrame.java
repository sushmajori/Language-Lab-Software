import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ServerFrame extends JFrame implements ActionListener 
{
JTextField jtf;
JTextArea jta;
JScrollPane jsp;
JButton btnSend;
JLabel lbl;
String str;
ServerDemo sd;
String name1;
int no1; 
String address1;
ServerFrame() throws Exception
{
setTitle("Teacher Panel");
setSize(500,500);
setLocation(300,50);
setResizable(false);
setLayout(null);
lbl=new JLabel("Teachers Panel",JLabel.CENTER);
lbl.setFont(new Font("Times New Roman",Font.BOLD,25));
jtf=new JTextField();
jta=new JTextArea();
jsp=new JScrollPane(jta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

btnSend=new JButton("SEND");
lbl.setBounds(100,1,300,80);
add(lbl);
jtf.setBounds(30,100,300,80);
add(jtf);
jsp.setBounds(30,200,450,200);
add(jsp);
jtf.setFont(new Font("Times New Roman",Font.BOLD,25));
jta.setFont(new Font("Times New Roman",Font.BOLD,25));
btnSend=new JButton("Send");
btnSend.setBounds(380,100,90,80);
btnSend.setFont(new Font("Times New Roman",Font.BOLD,25));
System.out.println("line 47");
add(btnSend);
btnSend.addActionListener(this);
setVisible(true);
 sd=new ServerDemo(this,1234,1); 
System.out.println("line 52");

while(true)
sd.receive();

}
public void actionPerformed(ActionEvent ae)
{
try
{
sd.send();

}
catch(Exception e)
{
System.out.println(e);
}
}

public static void main(String args[])
{
try
{
new ServerFrame();

}
catch(Exception e)
{
System.out.println(e);
}

}

}