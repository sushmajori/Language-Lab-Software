import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ClientFrame extends JFrame implements ActionListener 
{
JTextField jtf;
JTextArea jta;
JScrollPane jsp;
JButton btnSend;
JLabel lbl;
String str;
client1 c1;

ClientFrame() throws Exception
{
setTitle("Student Panel");
setSize(500,500);
setLocation(500,50);
setResizable(false);
setLayout(null);
lbl=new JLabel("Students Panel",JLabel.CENTER);
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

add(btnSend);
btnSend.addActionListener(this);
setVisible(true);

c1=new client1(this);
while(true)
c1.receive();

}
public void actionPerformed(ActionEvent ae)
{
try
{
c1.send();
}
catch(Exception e)
{
System.out.println(e);
}
}
public static void main(String args[]) throws Exception
{
new ClientFrame();
 
}

}