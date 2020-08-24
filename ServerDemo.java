import java.net.*;
import java.io.*;
class ServerDemo  
{
InputStream is[];
OutputStream os[];
Socket s[];
String msg;
byte b[];
int no;
ServerFrame sf1;
ServerDemo(ServerFrame sf,int port,int noOFclient) throws Exception
{
sf1=sf;
no=noOFclient;
ServerSocket ss=new ServerSocket(port);
is=new InputStream[noOFclient];
os=new OutputStream[noOFclient];
s=new Socket[noOFclient];
for(int i=0;i<noOFclient;i++)
{
s[i]=ss.accept();
is[i]=s[i].getInputStream();
os[i]=s[i].getOutputStream();
}
}
public void send() throws Exception
{
//DataInputStream dis=new DataInputStream(System.in);
msg=sf1.jtf.getText();
sf1.jta.append(msg+"\n");
msg=msg+"~";
for(int i=0;i<no;i++)
os[i].write(msg.getBytes());

sf1.jtf.setText("");

}


public void receive() throws Exception
{
String msg="",actualMsg="";

b=new byte[50];

for(int i=0;i<no;i++)
is[i].read(b);

msg=new String(b);

System.out.println(msg);
//sf1.jtf.setText("");
char ch;
for(int i=0;i<msg.length();i++)
{
ch=msg.charAt(i);
if((ch)=='~')
{
break;
}
actualMsg=actualMsg+ch;
}

sf1.jtf.setText("");
sf1.jta.append(actualMsg+"\n");

}




}