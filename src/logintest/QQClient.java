package logintest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class QQClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		Scanner input=new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username=input.next();
		System.out.println("请输入密码:");
		String password=input.next();
		
		try {
			//产生客户端套接字
			Socket socket =new Socket(Gloables.SERVERHOST,Gloables.SERVERPORT);
			//打印出IP地址和端口号
			System.out.println(socket.getInetAddress().getHostAddress()+"\t"+socket.getPort());
			//把手工录入的信息包装成User对象
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			//产生对象流传用户至服务器
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			
			//通过对象输出流把客户端这边录入的对象传给服务器
			oos.writeObject(user);
			oos.flush();
			//通过对象输入流把服务器传过来的对象读取过来
			Object o=ois.readObject();
			//转换成User类型
			User u=(User)o;
			if(u!=null){
				System.out.println("客户端登陆成功！");
			}else {
				
				System.out.println("登陆失败，请重试！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
