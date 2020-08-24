import java.net.*;
import java.io.*;
class client1
{

InputStream is;
OutputStream os;
 byte b[];
ClientFrame cf1;
String msg="",actualMsg="";
Socket s;
client1(ClientFrame cf) throws Exception
{
cf1=cf;
 s=new Socket("127.0.0.1",1234);

is=s.getInputStream();
os=s.getOutputStream();

}
public void send() throws Exception
{
//DataInputStream dis=new DataInputStream(System.in);
msg=cf1.jtf.getText();
cf1.jta.append(msg+"\n");
msg=msg+"~";
os.write(msg.getBytes());
cf1.jtf.setText("");

}


public void receive() throws Exception
{
String msg="",actualMsg="";

b=new byte[50];

is.read(b);
msg=new String(b);

System.out.println(msg);
cf1.jtf.setText("");
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

cf1.jta.append(actualMsg+"\n");

}

}