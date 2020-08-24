import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Login extends JFrame implements ActionListener
{
Label lblUser,lblPass;
TextField txtUser,txtPass;
Button btnSign,btnCancel;
Login l1;
//Home h;
Login()
{
setVisible(true);
setSize(300,250);
setTitle("Login to application");
setLocation(200,100);
setResizable(false);
setLayout(null);
lblUser=new Label("UserName");
lblPass=new Label("Password");
lblUser.setBounds(40,40,80,50);
lblPass.setBounds(40,120,80,50);
add(lblUser);
add(lblPass);
 Choice c1=new Choice();
c1.add("staff");
c1.add("stud");
txtUser=new TextField();
txtPass=new TextField();
txtUser.setBounds(150,50,120,30);
txtPass.setBounds(150,130,120,30);
add(c1);
add(txtPass);
add(txtUser);
txtPass.setEchoChar('*');
btnSign=new Button("SignIn");
btnSign.setBounds(80,180,80,50);
add(btnSign);
btnCancel=new Button("Cancel");
btnCancel.setBounds(180,180,80,50);
add(btnCancel);
btnSign.addActionListener(this);
btnCancel.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{


if(ae.getSource()==btnSign)
{
	System.out.println("sign in button Pressed");
	if(txtUser.getText().equals("admin")&&txtPass.getText().equals("12345"))
	{
JOptionPane.showMessageDialog(null,"Login successful","This is the title",
		JOptionPane.INFORMATION_MESSAGE);
		setVisible(false);
	//	new Home();
	}
		else
		{
JOptionPane.showMessageDialog(null,"Username or password is incorrect","Login",JOptionPane.ERROR_MESSAGE);
		System.out.println("Login not successful");

		}
}
		if(ae.getSource()==btnCancel)
		{
			System.out.println("cancel Button pressed");
			setVisible(false);

		}
}
public static void main(String args[])
  {
Login l1=new Login();
  } 

}